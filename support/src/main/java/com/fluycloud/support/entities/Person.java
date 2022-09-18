package com.fluycloud.support.entities;

import java.util.Objects;

public class Person {

    private Integer id;
    private String name;
    private String cpfCnpj;
    private String phoneNumber;
    private String email;
    private PersonType type;
    private City city;
    private String address;
    private String addressNumber;
    private String district;
    private String complement;
    private String zipCode;
    private String referencePoint;

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {

        private final Person person = new Person();

        public PersonBuilder id(Integer id) {
            this.person.id = id;
            return this;
        }
        public PersonBuilder name(String name) {
            this.person.name = name;
            return this;
        }

        public PersonBuilder cpfCnpj(String cpfCnpj) {
            this.person.cpfCnpj = cpfCnpj;
            return this;
        }

        public PersonBuilder phoneNumber(String phoneNumber) {
            this.person.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder email(String email) {
            this.person.email = email;
            return this;
        }

        public PersonBuilder type(PersonType type) {
            this.person.type = type;
            return this;
        }

        public PersonBuilder city(City city) {
            this.person.city = city;
            return this;
        }

        public PersonBuilder address(String address) {
            this.person.address = address;
            return this;
        }

        public PersonBuilder addressNumber(String addressNumber) {
            this.person.addressNumber = addressNumber;
            return this;
        }

        public PersonBuilder district(String district) {
            this.person.district = district;
            return this;
        }

        public PersonBuilder complement(String complement) {
            this.person.complement = complement;
            return this;
        }

        public PersonBuilder zipCode(String zipCode) {
            this.person.zipCode = zipCode;
            return this;
        }

        public PersonBuilder referencePoint(String referencePoint) {
            this.person.referencePoint = referencePoint;
            return this;
        }

        public Person build() {
            return this.person;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public PersonType getType() {
        return type;
    }

    public City getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getDistrict() {
        return district;
    }

    public String getComplement() {
        return complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
