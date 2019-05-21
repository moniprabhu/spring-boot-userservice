package com.stackroute.userservice.service;

import com.stackroute.exception.UserAlreadyExistException;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){

        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user)throws UserAlreadyExistException {
        if(userRepository.existsById(user.getId()))
        {
            throw new UserAlreadyExistException("User Already Exists");
        }
        User savedUser=userRepository.save(user);
        if(savedUser == null)
        {
            throw new UserAlreadyExistException("User Already Exists");
        }

        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
