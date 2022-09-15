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
                customer.getTradeName(),
                customer.getActive()
        );
    }

    public CustomerResponse mapResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getCompanyName(),
                customer.getTradeName(),
                customer.getCnpj(),
                customer.getCep(),
                customer.getCityId(),
                customer.getAddress(),
                customer.getAddressNumber(),
                customer.getDistrict(),
                customer.getComplement(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getActive()
        );
    }

    public Customer map(CustomerRequest request) {
        return new Customer.CustomerBuilder()
                .companyName(request.companyName())
                .tradeName(request.tradeName())
                .phoneNumber(request.phoneNumber().replaceAll("\\D", ""))
                .email(request.email())
                .cnpj(request.cnpj().replaceAll("\\D", ""))
                .address(request.address())
                .addressNumber(request.addressNumber())
                .district(request.district())
                .complement(request.complement())
                .schemaName(StringUtil.stripAccents(request.companyName()))
                .cep(request.cep().replaceAll("\\D", ""))
                .cityId(request.cityId())
                .active(request.active())
                .build();
    }

}
