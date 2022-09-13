package transport.response;

public record CompanyListResponse(
        Integer id,
        String companyName,
        String tradeName,
        String cnpj
) {}
