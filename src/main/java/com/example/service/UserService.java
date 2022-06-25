package com.example.service;

import com.example.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {

    void add(User user);
    void delete(User user);
    List<User> listUsers();
    User getUserById(long id);
    User getUserByUsername(String username);
    void update(User user);
}
