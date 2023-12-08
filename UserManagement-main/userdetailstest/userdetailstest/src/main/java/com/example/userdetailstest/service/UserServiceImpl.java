package com.example.userdetailstest.service;

import com.example.userdetailstest.entity.User;
import com.example.userdetailstest.exception.UserAlreadyExistsException;
import com.example.userdetailstest.exception.UserNotFoundException;
import com.example.userdetailstest.jwt.JwtTokenUtil;
import com.example.userdetailstest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    public User createUser(User user) {
        // Check if the user already exists by email (you can adjust this logic)
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User with Name " + user.getUsername() + " already exists");
        }

        // Encode the user's password before storing it in the database
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Set other properties as needed
//        user.setStatus(UserStatus.ACTIVE); // Assuming you have a UserStatus enum

        // Save the user to the database
        return userRepository.save(user);
    }



    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        // Update the properties of the existing user with the properties from updatedUser
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setLast_name(updatedUser.getLast_name());
        // Update other properties...

        return userRepository.save(existingUser);
    }

    @Override
    public Boolean deleteUser(Long id) {
        // Check if the user exists
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return false; // User not found
        }

        userRepository.delete(existingUser);
        return true;
    }

//    @Override
//    public User getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String loginUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

}
