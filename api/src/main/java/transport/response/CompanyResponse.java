package transport.response;

public record CompanyResponse(
        Integer id,
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
) {}