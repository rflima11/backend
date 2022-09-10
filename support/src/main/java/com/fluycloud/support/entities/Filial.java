package com.fluycloud.support.entities;

public class Filial {
    private Integer id;
    private Integer companyId;
    private String companyName;
    private String tradeName;
    private String cnpj;
    private Integer cityId;
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

        private final Filial filial = new Filial();

        public FilialBuilder id(Integer id) {
            this.filial.id = id;
            return this;
        }

        public FilialBuilder companyId(Integer companyId) {
            this.filial.companyId = companyId;
            return this;
        }

        public FilialBuilder companyName(String companyName) {
            this.filial.companyName = companyName;
            return this;
        }

        public FilialBuilder tradeName(String tradeName) {
            this.filial.tradeName = tradeName;
            return this;
        }

        public FilialBuilder cnpj(String cnpj) {
            this.filial.cnpj = cnpj;
            return this;
        }

        public FilialBuilder cityId(Integer cityId) {
            this.filial.cityId = cityId;
            return this;
        }

        public FilialBuilder zipCode(String zipCode) {
            this.filial.zipCode = zipCode;
            return this;
        }

        public FilialBuilder address(String address) {
            this.filial.address = address;
            return this;
        }

        public FilialBuilder addressNumber(String addressNumber) {
            this.filial.addressNumber = addressNumber;
            return this;
        }

        public FilialBuilder district(String district) {
            this.filial.district = district;
            return this;
        }

        public FilialBuilder complement(String complement) {
            this.filial.complement = complement;
            return this;
        }

        public FilialBuilder phoneNumber(String phoneNumber) {
            this.filial.phoneNumber = phoneNumber;
            return this;
        }

        public FilialBuilder email(String email) {
            this.filial.email = email;
            return this;
        }

        public FilialBuilder stateRegister(String stateRegister) {
            this.filial.stateRegister = stateRegister;
            return this;
        }

        public FilialBuilder municipalRegister(String municipalRegister) {
            this.filial.municipalRegister = municipalRegister;
            return this;
        }

        public Filial build() {
            return this.filial;
        }

    }

    public Integer getId() {
        return id;
    }

    public Integer getCompanyId() {
        return companyId;
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

    public Integer getCityId() {
        return cityId;
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
