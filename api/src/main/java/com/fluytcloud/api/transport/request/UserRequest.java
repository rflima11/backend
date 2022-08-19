package com.fluytcloud.api.transport.request;

import java.util.List;

public record UserRequest(String name, String email, List<String> branches) {
}
