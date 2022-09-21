package com.fluytcloud.core.entities;

import java.util.Optional;

public record UserInfo(String name, String username, Organization organization, Optional<Company> company) {
}
