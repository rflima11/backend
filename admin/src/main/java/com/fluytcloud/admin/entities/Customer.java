package com.fluytcloud.admin.entities;

import java.util.Objects;

public class Customer {

    private Integer id;
    private String schemaName;
    private String companyName;
    private String tradeName;
    private String cnpj;
    private String cep;
    private Integer cityId;
    private String address;
    private String addressNumber;
    private String district;
    private String complement;
    private String phoneNumber;
    private String email;
    private Boolean active;

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static class CustomerBuilder {

        private final Customer customer = new Customer();

        public CustomerBuilder id(Integer id) {
            this.customer.id = id;
            return this;
        }

        public CustomerBuilder schemaName(String schemaName) {
            this.customer.schemaName = schemaName;
            return this;
        }

        public CustomerBuilder companyName(String companyName) {
            this.customer.companyName = companyName;
            return this;
        }

        public CustomerBuilder tradeName(String tradeName) {
            this.customer.tradeName = tradeName;
            return this;
        }

        public CustomerBuilder cnpj(String cnpj) {
            this.customer.cnpj = cnpj;
            return this;
        }

        public CustomerBuilder cep(String cep) {
            this.customer.cep = cep;
            return this;
        }

        public CustomerBuilder cityId(Integer cityId) {
            this.customer.cityId = cityId;
            return this;
        }

        public CustomerBuilder address(String address) {
            this.customer.address = address;
            return this;
        }

        public CustomerBuilder addressNumber(String addressNumber) {
            this.customer.addressNumber = addressNumber;
            return this;
        }

        public CustomerBuilder district(String district) {
            this.customer.district = district;
            return this;
        }

        public CustomerBuilder complement(String complement) {
            this.customer.complement = complement;
            return this;
        }

        public CustomerBuilder phoneNumber(String phoneNumber) {
            this.customer.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder email(String email) {
            this.customer.email = email;
            return this;
        }

        public CustomerBuilder active(Boolean active) {
            this.customer.active = active;
            return this;
        }

        public Customer build() {
            return this.customer;
        }

    }

    public Integer getId() {
        return id;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCep() {
        return cep;
    }

    public Integer getCityId() {
        return cityId;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getDistrict() {
        return district;
    }

    public String getComplement() {
        return complement;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
