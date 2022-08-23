package com.fluytcloud.auth.interactors;

import com.fluytcloud.auth.entities.User;
import com.fluytcloud.auth.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean create(User user) {
        return userRepository.create(user);
    }

}
