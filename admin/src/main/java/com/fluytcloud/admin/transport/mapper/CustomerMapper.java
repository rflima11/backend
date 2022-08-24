package com.fluytcloud.admin.transport.mapper;

import com.fluytcloud.admin.entities.Customer;
import com.fluytcloud.admin.transport.request.CustomerRequest;
import com.fluytcloud.admin.transport.response.CustomerListResponse;
import com.fluytcloud.admin.util.StringUtil;

public class CustomerMapper {

    public CustomerListResponse map(Customer customer) {
        return new CustomerListResponse(
                customer.getId(),
                customer.getCompanyName(),
                customer.getTradeName()
        );
    }

    public Customer map(CustomerRequest request) {
        return new Customer.CustomerBuilder()
                .companyName(request.getCompanyName())
                .tradeName(request.getTradeName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .cnpj(request.getCnpj())
                .address(request.getAddress())
                .addressNumber(request.getAddressNumber())
                .district(request.getDistrict())
                .complement(request.getComplement())
                .schemaName(StringUtil.stripAccents(request.getCompanyName()))
                .cityId(request.getCityId())
                .build();
    }

}
