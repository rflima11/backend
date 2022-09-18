package transport.response;

public record PersonListResponse(
        Integer id,
        String name,
        String cpfCnpj
) {
}
