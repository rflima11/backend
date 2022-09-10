package com.fluycloud.support.datasources.relational.mapper;

import com.fluycloud.support.datasources.relational.model.FilialModel;
import com.fluycloud.support.entities.Filial;

public interface FilialModelMapper {

    FilialModelMapper INSTANCE = new FilialModelMapper() {};

    default Filial map(FilialModel filialModel) {
        return new Filial.FilialBuilder()
                .id(filialModel.getId())
                .companyId(filialModel.getCompanyId())
                .companyName(filialModel.getCompanyName())
                .tradeName(filialModel.getTradeName())
                .phoneNumber(filialModel.getPhoneNumber())
                .cityId(filialModel.getCityId())
                .zipCode(filialModel.getZipCode())
                .email(filialModel.getEmail())
                .cnpj(filialModel.getCnpj())
                .address(filialModel.getAddress())
                .addressNumber(filialModel.getAddressNumber())
                .district(filialModel.getDistrict())
                .complement(filialModel.getComplement())
                .stateRegister(filialModel.getStateRegister())
                .municipalRegister(filialModel.getMunicipalRegister())
                .build();
    }

    default FilialModel map(Filial filial) {
        return new FilialModel()
                .setId(filial.getId())
                .setCompanyId(filial.getCompanyId())
                .setPhoneNumber(filial.getPhoneNumber())
                .setCompanyName(filial.getCompanyName())
                .setTradeName(filial.getTradeName())
                .setCityId(filial.getCityId())
                .setZipCode(filial.getZipCode())
                .setEmail(filial.getEmail())
                .setCnpj(filial.getCnpj())
                .setAddress(filial.getAddress())
                .setAddressNumber(filial.getAddressNumber())
                .setDistrict(filial.getDistrict())
                .setComplement(filial.getComplement())
                .setStateRegister(filial.getStateRegister())
                .setMunicipalRegister(filial.getMunicipalRegister());
    }
}
