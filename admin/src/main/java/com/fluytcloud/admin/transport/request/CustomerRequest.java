package com.fluytcloud.admin.transport.request;

public class CustomerRequest {

    private String companyName;
    private String tradeName;
    private String cnpj;
    private Integer cityId;
    private String address;
    private String addressNumber;
    private String district;
    private String complement;
    private String phoneNumber;
    private String email;

    public String getCompanyName() {
        return companyName;
    }

    public CustomerRequest setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getTradeName() {
        return tradeName;
    }

    public CustomerRequest setTradeName(String tradeName) {
        this.tradeName = tradeName;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public CustomerRequest setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public Integer getCityId() {
        return cityId;
    }

    public CustomerRequest setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerRequest setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public CustomerRequest setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public CustomerRequest setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public CustomerRequest setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}
