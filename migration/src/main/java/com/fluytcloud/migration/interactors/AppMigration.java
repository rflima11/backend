package com.fluytcloud.migration.interactors;

import io.quarkus.runtime.Startup;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

@Startup
@ApplicationScoped
public class AppMigration {

    private final DataSource dataSource;

    public AppMigration(DataSource dataSource) {
        this.dataSource = dataSource;
        migration("test");
    }

    public boolean migration(String schema) {
        var configuration = new FluentConfiguration()
                .dataSource(dataSource)
                .locations("db/migration/app")
                .schemas(schema);

        return new Flyway(configuration).migrate().success;
    }

}
