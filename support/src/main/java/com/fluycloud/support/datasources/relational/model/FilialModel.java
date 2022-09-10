package com.fluycloud.support.datasources.relational.model;

import javax.persistence.*;

@Entity
@Table(name = "FILIAL")
public class FilialModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "COMPANY_NAME", length = 100, nullable = false)
    private String companyName;

    @Column(name = "TRADE_NAME", length = 100, nullable = false)
    private String tradeName;

    @Column(name = "CNPJ", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "CITY_ID", nullable = false)
    private Integer cityId;

    @Column(name = "ZIP_CODE", length = 8)
    private String zipCode;

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

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "STATE_REGISTER", length = 9, nullable = false)
    private String stateRegister;

    @Column(name = "MUNICIPAL_REGISTER", length = 11, nullable = false)
    private String municipalRegister;

    public Integer getId() {
        return id;
    }

    public FilialModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public FilialModel setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public FilialModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getTradeName() {
        return tradeName;
    }

    public FilialModel setTradeName(String tradeName) {
        this.tradeName = tradeName;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public FilialModel setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public Integer getCityId() {
        return cityId;
    }

    public FilialModel setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public FilialModel setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public FilialModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public FilialModel setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public FilialModel setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public FilialModel setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public FilialModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FilialModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStateRegister() {
        return stateRegister;
    }

    public FilialModel setStateRegister(String stateRegister) {
        this.stateRegister = stateRegister;
        return this;
    }

    public String getMunicipalRegister() {
        return municipalRegister;
    }

    public FilialModel setMunicipalRegister(String municipalRegister) {
        this.municipalRegister = municipalRegister;
        return this;
    }
}
