package com.fluytcloud.admin.datasources.relational.mapper;

import com.fluytcloud.admin.datasources.relational.model.CustomerModel;
import com.fluytcloud.admin.entities.Customer;

public class CustomerModelMapper {

    public Customer map(CustomerModel customerModel) {
        return new Customer.CustomerBuilder()
                .id(customerModel.getId())
                .schemaName(customerModel.getSchemaName())
                .companyName(customerModel.getCompanyName())
                .tradeName(customerModel.getTradeName())
                .cityId(customerModel.getCityId())
                .cnpj(customerModel.getCnpj())
                .address(customerModel.getAddress())
                .addressNumber(customerModel.getAddressNumber())
                .district(customerModel.getDistrict())
                .complement(customerModel.getComplement())
                .build();
    }

}
