package com.fitness_social_media.fitness_social_media.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitness_social_media.fitness_social_media.models.User;

@RestController
public class UserController {
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1,"John", "Doe", "johndoe@gmail.com","JohnDeo");
        User user2 = new User(2,"Dilanka", "Prasad", "dpl@gmail.com","Dilanka");
        users.add(user1);
        users.add(user2);
        return users;
    }
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable ("userId") Integer id) {        
        User user1 = new User(1,"John", "Doe", "johndoe@gmail.com","JohnDeo");
        user1.setId(id);
        return user1;
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        User newUser=new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return newUser;
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        User user1 = new User(1,"John", "Doe", "johndoe@gmail.com","JohnDeo");
        if(user.getFirstName()!=null){
            user1.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            user1.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null){
            user1.setEmail(user.getEmail());
        }
       
        return user1;
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id){
        return "User deleted successfully with id no "+id;
    }


}
