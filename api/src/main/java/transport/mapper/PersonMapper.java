package transport.mapper;

import com.fluycloud.support.entities.Person;
import transport.request.PersonRequest;
import transport.response.PersonListResponse;
import transport.response.PersonResponse;

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

    public Person map(PersonRequest request) {
        return Person.builder()
                .id(request.id())
                .name(request.name())
                .type(request.type())
                .cpfCnpj(request.cpfCnpj().replaceAll("\\D", ""))
                .city(CityMapper.map(request.city()))
                .zipCode(request.zipCode())
                .address(request.address())
                .addressNumber(request.addressNumber())
                .district(request.district())
                .complement(request.complement())
                .phoneNumber(request.phoneNumber().replaceAll("\\D", ""))
                .email(request.email())
                .referencePoint(request.referencePoint())
                .build();
    }
}
