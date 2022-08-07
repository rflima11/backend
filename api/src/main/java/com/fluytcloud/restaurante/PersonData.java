package com.fluytcloud.restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonData extends JpaRepository<Person, Long> {
}
