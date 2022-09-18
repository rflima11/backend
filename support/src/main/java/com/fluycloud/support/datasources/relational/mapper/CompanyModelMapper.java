package com.fluycloud.support.datasources.relational.mapper;

import com.fluycloud.support.datasources.relational.model.CompanyModel;
import com.fluycloud.support.entities.Company;

public interface CompanyModelMapper {

    CompanyModelMapper INSTANCE = new CompanyModelMapper() {};

    default Company map(CompanyModel companyModel) {
        return new Company.FilialBuilder()
                .id(companyModel.getId())
                .companyName(companyModel.getCompanyName())
                .tradeName(companyModel.getTradeName())
                .phoneNumber(companyModel.getPhoneNumber())
                .city(CityMapper.map(companyModel.getCity()))
                .zipCode(companyModel.getZipCode())
                .email(companyModel.getEmail())
                .cnpj(companyModel.getCnpj())
                .address(companyModel.getAddress())
                .addressNumber(companyModel.getAddressNumber())
                .district(companyModel.getDistrict())
                .complement(companyModel.getComplement())
                .stateRegister(companyModel.getStateRegister())
                .municipalRegister(companyModel.getMunicipalRegister())
                .build();
    }

    default CompanyModel map(Company company) {
        return new CompanyModel()
                .setId(company.getId())
                .setPhoneNumber(company.getPhoneNumber())
                .setCompanyName(company.getCompanyName())
                .setTradeName(company.getTradeName())
                .setCity(CityMapper.map(company.getCity()))
                .setZipCode(company.getZipCode())
                .setEmail(company.getEmail())
                .setCnpj(company.getCnpj())
                .setAddress(company.getAddress())
                .setAddressNumber(company.getAddressNumber())
                .setDistrict(company.getDistrict())
                .setComplement(company.getComplement())
                .setStateRegister(company.getStateRegister())
                .setMunicipalRegister(company.getMunicipalRegister());
    }
}
