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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fitness_social_media.fitness_social_media.exceptions.UserException;
import com.fitness_social_media.fitness_social_media.models.User;
import com.fitness_social_media.fitness_social_media.repository.UserRepository;
import com.fitness_social_media.fitness_social_media.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    // Create a new user
    // @PostMapping("/users")
    // public User createUser(@RequestBody User user){
    //     User savedUser=userService.registerUser(user);
    //     return savedUser;
    // }

    // Get all users
    @GetMapping("/api/users")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();        
        return users;
    }

    // Get a specific user by id
    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable ("userId") Integer id) throws UserException {        
        User user = userService.findUserById(id);
        return user;
    }
    
    // Update an existing user by Id
    @PutMapping("/api/users")
    public User updateUser(@RequestHeader ("Authorization") String jwt,@RequestBody User user) throws UserException{
       
       User reqUser=userService.findUserByJwt(jwt);
       User updatedUser=userService.updateUser(user, reqUser.getId());
       return updatedUser;
    }

    @PutMapping("/api/users/follow/{userId2}")
    public User followUserHandler(@RequestHeader ("Authorization") String jwt,@PathVariable Integer userId2) throws UserException{
        
        User reqUserId=userService.findUserByJwt(jwt);
        User user=userService.followUser(reqUserId.getId(), userId2);
        return user;
    }

    @GetMapping("/api/users/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> users=userService.searchUser(query);
        return users;
    }

    @GetMapping("/api/users/profile")
    public User getUserFromToken(@RequestHeader ("Authorization") String jwt) {
        User user=userService.findUserByJwt(jwt);
        user.setPassword(null);
        return user;
    }

    // Delete a user by Id
    // @DeleteMapping("/users/{userId}")
    // public String deleteUser(@PathVariable("userId") Integer id) throws Exception{
    //     java.util.Optional<User> user = userRepository.findById(id);
    //     if(user.isEmpty()){
    //         throw new Exception("user not exised with id " + id);
    //     }
    //     userRepository.delete(user.get());
    //     return "User deleted successfully with id no "+id;
    // }


}
