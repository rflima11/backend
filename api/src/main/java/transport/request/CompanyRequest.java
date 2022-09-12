package transport.request;

public record CompanyRequest(
        String companyName,
        String tradeName,
        String cnpj,
        Integer cityId,
        String zipCode,
        String address,
        String addressNumber,
        String district,
        String complement,
        String phoneNumber,
        String email,
        String stateRegister,
        String municipalRegister
){}
