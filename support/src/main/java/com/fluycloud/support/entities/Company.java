package com.fluycloud.support.entities;

public class Company {
    private Integer id;
    private String companyName;
    private String tradeName;
    private String cnpj;
    private City city;
    private String zipCode;
    private String address;
    private String addressNumber;
    private String district;
    private String complement;
    private String phoneNumber;
    private String email;
    private String stateRegister;
    private String municipalRegister;

    public static FilialBuilder builder() {
        return new FilialBuilder();
    }

    public static class FilialBuilder {

        private final Company company = new Company();

        public FilialBuilder id(Integer id) {
            this.company.id = id;
            return this;
        }
        public FilialBuilder companyName(String companyName) {
            this.company.companyName = companyName;
            return this;
        }

        public FilialBuilder tradeName(String tradeName) {
            this.company.tradeName = tradeName;
            return this;
        }

        public FilialBuilder cnpj(String cnpj) {
            this.company.cnpj = cnpj;
            return this;
        }

        public FilialBuilder city(City city) {
            this.company.city = city;
            return this;
        }

        public FilialBuilder zipCode(String zipCode) {
            this.company.zipCode = zipCode;
            return this;
        }

        public FilialBuilder address(String address) {
            this.company.address = address;
            return this;
        }

        public FilialBuilder addressNumber(String addressNumber) {
            this.company.addressNumber = addressNumber;
            return this;
        }

        public FilialBuilder district(String district) {
            this.company.district = district;
            return this;
        }

        public FilialBuilder complement(String complement) {
            this.company.complement = complement;
            return this;
        }

        public FilialBuilder phoneNumber(String phoneNumber) {
            this.company.phoneNumber = phoneNumber;
            return this;
        }

        public FilialBuilder email(String email) {
            this.company.email = email;
            return this;
        }

        public FilialBuilder stateRegister(String stateRegister) {
            this.company.stateRegister = stateRegister;
            return this;
        }

        public FilialBuilder municipalRegister(String municipalRegister) {
            this.company.municipalRegister = municipalRegister;
            return this;
        }

        public Company build() {
            return this.company;
        }
    }

    public Integer getId() {
        return id;
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

    public City getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
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

    public String getStateRegister() {
        return stateRegister;
    }

    public String getMunicipalRegister() {
        return municipalRegister;
    }
}
