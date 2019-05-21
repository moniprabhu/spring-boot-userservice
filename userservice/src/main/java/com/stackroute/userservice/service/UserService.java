package com.stackroute.userservice.service;

import com.stackroute.exception.UserAlreadyExistException;
import com.stackroute.userservice.domain.User;

import java.util.*;

public interface UserService {
    public User saveUser(User user)throws UserAlreadyExistException;

    public List<User>getAllUsers();
}
