package com.Ironhack.finalProjectserver.service.interfaces;

import com.Ironhack.finalProjectserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();
}
