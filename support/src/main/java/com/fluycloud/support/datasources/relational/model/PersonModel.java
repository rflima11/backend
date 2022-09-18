package com.fluycloud.support.datasources.relational.model;

import com.fluycloud.support.entities.PersonType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSON",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UQ_PERSON_CPF_CNPJ", columnNames = "CPF_CNPJ"
                )}
)
public class PersonModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PersonType type;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "CPF_CNPJ", length = 14, nullable = false)
    private String cpfCnpj;

    @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private CityModel city;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "ADDRESS_NUMBER", length = 50)
    private String addressNumber;

    @Column(name = "DISTRICT", length = 100)
    private String district;

    @Column(name = "COMPLEMENT", length = 200)
    private String complement;

    @Column(name = "ZIP_CODE", length = 8)
    private String zipCode;

    @Column(name = "REFERENCE_POINT", length =100)
    private String referencePoint;

    public Integer getId() {
        return id;
    }

    public PersonModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public PersonType getType() {
        return type;
    }

    public PersonModel setType(PersonType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public PersonModel setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PersonModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public CityModel getCity() {
        return city;
    }

    public PersonModel setCity(CityModel city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PersonModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public PersonModel setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public PersonModel setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public PersonModel setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public PersonModel setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public PersonModel setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonModel that = (PersonModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
