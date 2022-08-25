package com.fluytcloud.admin.transport.mapper;

import com.fluytcloud.admin.entities.Customer;
import com.fluytcloud.admin.transport.request.CustomerRequest;
import com.fluytcloud.admin.transport.response.CustomerListResponse;
import com.fluytcloud.admin.transport.response.CustomerResponse;
import com.fluytcloud.admin.util.StringUtil;

public class CustomerMapper {

    public CustomerListResponse mapResponseList(Customer customer) {
        return new CustomerListResponse(
                customer.getId(),
                customer.getCompanyName(),
                customer.getTradeName()
        );
    }

    public CustomerResponse mapResponse(Customer customer) {
        return new CustomerResponse(
                customer.getCompanyName(),
                customer.getTradeName(),
                customer.getCnpj(),
                customer.getCityId(),
                customer.getAddress(),
                customer.getAddressNumber(),
                customer.getDistrict(),
                customer.getComplement(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );
    }

    public Customer map(CustomerRequest request) {
        return new Customer.CustomerBuilder()
                .companyName(request.companyName())
                .tradeName(request.tradeName())
                .phoneNumber(request.phoneNumber())
                .email(request.email())
                .cnpj(request.cnpj())
                .address(request.address())
                .addressNumber(request.addressNumber())
                .district(request.district())
                .complement(request.complement())
                .schemaName(StringUtil.stripAccents(request.companyName()))
                .cityId(request.cityId())
                .build();
    }

}
