package com.fluytcloud.auth.datasources.relational.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "AuthCustomerModel")
@Table(name = "CUSTOMER", schema = "admin")
public class CustomerModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SCHEMA_NAME", length = 63, nullable = false, unique = true)
    private String schemaName;

    @Column(name = "TRADE_NAME", length = 100, nullable = false)
    private String tradeName;

    public Integer getId() {
        return id;
    }

    public CustomerModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public CustomerModel setSchemaName(String schemaName) {
        this.schemaName = schemaName;
        return this;
    }

    public String getTradeName() {
        return tradeName;
    }

    public CustomerModel setTradeName(String tradeName) {
        this.tradeName = tradeName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
