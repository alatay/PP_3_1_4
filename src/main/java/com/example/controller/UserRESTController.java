package com.example.controller;


import com.example.model.Role;
import com.example.model.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRESTController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/admin")
    public List<User> listUsers() {
        List<User> users = userService.listUsers();
        return users;
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        List<Role> roles = roleService.findAll();
        return roles;
    }

    @GetMapping("/user")
    public User getUser(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return user;
    }



    @PostMapping("/admin/user/new")
    public User addUser(@RequestBody User user) {
        userService.add(user);
        return user;
    }


    @PatchMapping("/admin/user/edit")
    public User editUser(@RequestBody User user) {
        userService.update(user);
        return user;
    }

    @DeleteMapping("admin/user/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.delete(userService.getUserById(id));
    }
}
