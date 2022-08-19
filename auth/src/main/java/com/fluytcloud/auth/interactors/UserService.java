package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.entities.User;
import com.fluytcloud.auth.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public void create(User user) {
        userRepository.create(user);
    }

}
