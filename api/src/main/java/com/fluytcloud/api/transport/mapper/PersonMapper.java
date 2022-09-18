package com.fluytcloud.api.transport.mapper;

import com.fluycloud.support.entities.Person;
import com.fluytcloud.api.transport.request.PersonRequest;
import com.fluytcloud.api.transport.response.PersonListResponse;
import com.fluytcloud.api.transport.response.PersonResponse;

public class PersonMapper {

    public PersonListResponse mapResponseList(Person person) {
        return new PersonListResponse(
                person.getId(),
                person.getName(),
                person.getCpfCnpj()
        );
    }

    public PersonResponse mapResponse(Person person) {
        return new PersonResponse(
                person.getId(),
                person.getName(),
                person.getType(),
                person.getCpfCnpj(),
                CityMapper.map(person.getCity()),
                person.getZipCode(),
                person.getAddress(),
                person.getAddressNumber(),
                person.getDistrict(),
                person.getComplement(),
                person.getPhoneNumber(),
                person.getEmail(),
                person.getReferencePoint()
        );
    }

    public Person map(PersonRequest request, Integer id) {
        return Person.builder()
                .id(id)
                .name(request.name())
                .type(request.type())
                .cpfCnpj(request.cpfCnpj().replaceAll("\\D", ""))
                .city(CityMapper.map(request.city()))
                .zipCode(request.zipCode().replaceAll("\\D", ""))
                .address(request.address())
                .addressNumber(request.addressNumber())
                .district(request.district())
                .complement(request.complement())
                .phoneNumber(request.phoneNumber().replaceAll("\\D", ""))
                .email(request.email())
                .referencePoint(request.referencePoint())
                .build();
    }

    public Person map(PersonRequest request) {
        return map(request, null);
    }

}
