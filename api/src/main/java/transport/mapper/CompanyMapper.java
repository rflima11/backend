package transport.mapper;

import com.fluycloud.support.entities.Company;
import transport.request.CompanyRequest;
import transport.response.CompanyListResponse;
import transport.response.CompanyResponse;

public class CompanyMapper {

    public CompanyListResponse mapResponseList(Company company) {
        return new CompanyListResponse(
                company.getId(),
                company.getCompanyName(),
                company.getTradeName(),
                company.getCnpj()
        );
    }

    public CompanyResponse mapResponse(Company company) {
        return new CompanyResponse(
                company.getId(),
                company.getCompanyName(),
                company.getTradeName(),
                company.getCnpj(),
                company.getCityId(),
                company.getZipCode(),
                company.getAddress(),
                company.getAddressNumber(),
                company.getDistrict(),
                company.getComplement(),
                company.getPhoneNumber(),
                company.getEmail(),
                company.getStateRegister(),
                company.getMunicipalRegister()
        );
    }

    public Company map(CompanyRequest request) {
        return Company.builder()
                .companyName(request.companyName())
                .tradeName(request.tradeName())
                .cnpj(request.cnpj().replaceAll("\\D", ""))
                .cityId(request.cityId())
                .zipCode(request.zipCode())
                .address(request.address())
                .addressNumber(request.addressNumber())
                .district(request.district())
                .complement(request.complement())
                .phoneNumber(request.phoneNumber().replaceAll("\\D", ""))
                .email(request.email())
                .stateRegister(request.stateRegister())
                .municipalRegister(request.municipalRegister())
                .build();
    }

}
