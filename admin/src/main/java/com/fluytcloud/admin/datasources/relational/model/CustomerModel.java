package com.fluytcloud.admin.datasources.relational.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER", schema = "admin")
public class CustomerModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SCHEMA_NAME", length = 63, nullable = false, unique = true)
    private String schemaName;

    @Column(name = "COMPANY_NAME", length = 100, nullable = false)
    private String companyName;

    @Column(name = "TRADE_NAME", length = 100, nullable = false)
    private String tradeName;

    @Column(name = "CNPJ", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "CEP", length = 8, nullable = false)
    private String cep;

    @Column(name = "CITY_ID", nullable = false)
    private Integer cityId;

    @Column(name = "ADDRESS", length = 100, nullable = false)
    private String address;

    @Column(name = "ADDRESS_NUMBER", length = 50, nullable = false)
    private String addressNumber;

    @Column(name = "DISTRICT", length = 100, nullable = false)
    private String district;

    @Column(name = "COMPLEMENT", length = 200)
    private String complement;

    @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

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

    public String getCompanyName() {
        return companyName;
    }

    public CustomerModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getTradeName() {
        return tradeName;
    }

    public CustomerModel setTradeName(String tradeName) {
        this.tradeName = tradeName;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public CustomerModel setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public CustomerModel setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Integer getCityId() {
        return cityId;
    }

    public CustomerModel setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public CustomerModel setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public CustomerModel setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public CustomerModel setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public CustomerModel setActive(Boolean active) {
        this.active = active;
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
