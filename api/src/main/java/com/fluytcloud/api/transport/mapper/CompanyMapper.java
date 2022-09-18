package com.fluytcloud.api.transport.mapper;

import com.fluycloud.support.entities.Company;
import com.fluytcloud.api.transport.request.CompanyRequest;
import com.fluytcloud.api.transport.response.CompanyListResponse;
import com.fluytcloud.api.transport.response.CompanyResponse;

public class CompanyMapper {

    public CompanyListResponse mapResponseList(Company company) {
        return new CompanyListResponse(
                company.getId(),
                company.getCompanyName(),
                company.getTradeName(),
                company.getCnpj()
        );
    }

    public CompanyResponse mapResponse(Company company) {
        return new CompanyResponse(
                company.getId(),
                company.getCompanyName(),
                company.getTradeName(),
                company.getCnpj(),
                CityMapper.map(company.getCity()),
                company.getZipCode(),
                company.getAddress(),
                company.getAddressNumber(),
                company.getDistrict(),
                company.getComplement(),
                company.getPhoneNumber(),
                company.getEmail(),
                company.getStateRegister(),
                company.getMunicipalRegister()
        );
    }

    public Company map(CompanyRequest request) {
        return Company.builder()
                .id(request.id())
                .companyName(request.companyName())
                .tradeName(request.tradeName())
                .cnpj(request.cnpj().replaceAll("\\D", ""))
                .city(CityMapper.map(request.city()))
                .zipCode(request.zipCode().replaceAll("\\D", ""))
                .address(request.address())
                .addressNumber(request.addressNumber())
                .district(request.district())
                .complement(request.complement())
                .phoneNumber(request.phoneNumber().replaceAll("\\D", ""))
                .email(request.email())
                .stateRegister(request.stateRegister())
                .municipalRegister(request.municipalRegister())
                .build();
    }

}
