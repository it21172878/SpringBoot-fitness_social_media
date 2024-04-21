package com.fitness_social_media.fitness_social_media.controller;

// import java.util.ArrayList;
import java.util.List;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitness_social_media.fitness_social_media.models.User;
import com.fitness_social_media.fitness_social_media.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Create a new user
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        User newUser=new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        User savedUser=userRepository.save(newUser);
        return savedUser;
    }

    // Get all users
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();        
        return users;
    }

    // Get a specific user by id
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable ("userId") Integer id) throws Exception {        
        java.util.Optional<User> user=userRepository.findById(id);  
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("user not exist with user id " + id);
    }
    
    // Update an existing user by Id
    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable ("userId") Integer id) throws Exception{
       java.util.Optional<User> user1 = userRepository.findById(id);
       if(user1.isEmpty()){
        throw new Exception("user not exised with id " + id);
       }
       User oldUser=user1.get();

       if(user.getFirstName()!=null){
        oldUser.setFirstName(user.getFirstName());
       }
       
       if(user.getLastName()!=null){
        oldUser.setLastName(user.getLastName());
       }
       
       if(user.getEmail()!=null){
        oldUser.setEmail(user.getEmail());
       }

       User updateUser=userRepository.save(oldUser);

       return updateUser;
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) throws Exception{
        java.util.Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new Exception("user not exised with id " + id);
        }
        userRepository.delete(user.get());
        return "User deleted successfully with id no "+id;
    }


}
