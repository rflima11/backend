package com.fluytcloud.auth.repositories;

import com.fluytcloud.auth.entities.User;

public interface UserRepository {

    boolean create(User user);

}
