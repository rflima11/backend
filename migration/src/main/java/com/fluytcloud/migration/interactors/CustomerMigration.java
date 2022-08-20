package com.fluytcloud.migration.interactors;

import com.fluytcloud.migration.repositories.CustomerRepository;
import io.quarkus.runtime.Startup;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

@Startup
@ApplicationScoped
public class CustomerMigration {

    private final DataSource dataSource;
    private final CustomerRepository customerRepository;

    public CustomerMigration(DataSource dataSource, CustomerRepository customerRepository) {
        this.dataSource = dataSource;
        this.customerRepository = customerRepository;
        migrationAllCustomers();
    }

    /**
     * When closing a contract with a new customer, it is necessary to create your database schema
     * @param schema unique key per customer
     * @return successful migration
     */
    public boolean migration(String schema) {
        var configuration = new FluentConfiguration()
                .dataSource(dataSource)
                .locations("db/migration/app")
                .schemas(schema);

        return new Flyway(configuration).migrate().success;
    }

    /**
     * When starting application, the schemas of all customers must be migrated
     */
    public void migrationAllCustomers() {
        customerRepository.findAll().forEach(customer -> migration(customer.getSchemaName()));
    }

}
