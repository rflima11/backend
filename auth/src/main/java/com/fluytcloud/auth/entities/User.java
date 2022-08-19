package com.fluytcloud.auth.entities;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class User {

    private final String email;
    private final String name;
    private final String firstName;
    private final String lastName;
    private final String group;
    private final List<String> subGroups;

    public User(String email, String name, String group, List<String> subGroups) {
        this.email = Objects.requireNonNull(email);
        this.name = Objects.requireNonNull(name);
        this.group = group;
        this.subGroups = subGroups;

        var splitName = name.split(" ");
        firstName = splitName[0];
        if (splitName.length > 1) {
            lastName = splitName[1];
        } else {
            lastName = null;
        }

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public String getGroup() {
        return group;
    }

    public List<String> getSubGroups() {
        return Collections.unmodifiableList(subGroups);
    }
}
