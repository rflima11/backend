package com.fluycloud.support.datasources.relational.mapper;

import com.fluycloud.support.core.CrudMapper;
import com.fluycloud.support.datasources.relational.model.PersonModel;
import com.fluycloud.support.entities.Person;

public class PersonModelMapper implements CrudMapper<Person, PersonModel> {

    @Override
    public Person mapToEntity(PersonModel model) {
        return new Person.PersonBuilder()
                .id(model.getId())
                .name(model.getName())
                .type(model.getType())
                .phoneNumber(model.getPhoneNumber())
                .city(CityMapper.map(model.getCity()))
                .zipCode(model.getZipCode())
                .email(model.getEmail())
                .cpfCnpj(model.getCpfCnpj())
                .address(model.getAddress())
                .addressNumber(model.getAddressNumber())
                .district(model.getDistrict())
                .complement(model.getComplement())
                .referencePoint(model.getReferencePoint())
                .build();
    }

    @Override
    public PersonModel mapToModel(Person person) {
        return new PersonModel()
                .setId(person.getId())
                .setPhoneNumber(person.getPhoneNumber())
                .setName(person.getName())
                .setType(person.getType())
                .setCity(CityMapper.map(person.getCity()))
                .setZipCode(person.getZipCode())
                .setEmail(person.getEmail())
                .setCpfCnpj(person.getCpfCnpj())
                .setAddress(person.getAddress())
                .setAddressNumber(person.getAddressNumber())
                .setDistrict(person.getDistrict())
                .setComplement(person.getComplement())
                .setReferencePoint(person.getReferencePoint());
    }

}
