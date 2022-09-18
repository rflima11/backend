package com.fluycloud.support.datasources.relational.mapper;

import com.fluycloud.support.datasources.relational.model.PersonModel;
import com.fluycloud.support.entities.Person;

public interface PersonModelMapper {

    PersonModelMapper INSTANCE = new PersonModelMapper() {};

    default Person map(PersonModel personModel) {
        return new Person.PersonBuilder()
                .id(personModel.getId())
                .name(personModel.getName())
                .type(personModel.getType())
                .phoneNumber(personModel.getPhoneNumber())
                .city(CityMapper.map(personModel.getCity()))
                .zipCode(personModel.getZipCode())
                .email(personModel.getEmail())
                .cpfCnpj(personModel.getCpfCnpj())
                .address(personModel.getAddress())
                .addressNumber(personModel.getAddressNumber())
                .district(personModel.getDistrict())
                .complement(personModel.getComplement())
                .referencePoint(personModel.getReferencePoint())
                .build();
    }

    default PersonModel map(Person person) {
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
