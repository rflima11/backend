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
                .phoneNumber(customerModel.getPhoneNumber())
                .cep(customerModel.getCep())
                .cityId(customerModel.getCityId())
                .email(customerModel.getEmail())
                .cnpj(customerModel.getCnpj())
                .address(customerModel.getAddress())
                .addressNumber(customerModel.getAddressNumber())
                .district(customerModel.getDistrict())
                .complement(customerModel.getComplement())
                .active(customerModel.getActive())
                .build();
    }

    public CustomerModel map(Customer customer) {
        return new CustomerModel()
                .setId(customer.getId())
                .setSchemaName(customer.getSchemaName())
                .setPhoneNumber(customer.getPhoneNumber())
                .setCompanyName(customer.getCompanyName())
                .setTradeName(customer.getTradeName())
                .setCep(customer.getCep())
                .setCityId(customer.getCityId())
                .setEmail(customer.getEmail())
                .setCnpj(customer.getCnpj())
                .setAddress(customer.getAddress())
                .setAddressNumber(customer.getAddressNumber())
                .setDistrict(customer.getDistrict())
                .setComplement(customer.getComplement())
                .setActive(customer.getActive());
    }

}
