package com.example.userdetailstest.service;

import com.example.userdetailstest.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);

    User updateUser(Long id, User updatedUser);

    Boolean deleteUser(Long id);

    String loginUser(String username, String password);

    UserDetails loadUserByUsername(String username);

    List<User> getAllUsers();

    User getUserById(Long id);
}
