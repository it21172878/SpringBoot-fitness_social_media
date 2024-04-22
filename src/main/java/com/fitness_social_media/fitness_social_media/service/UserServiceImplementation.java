package com.fitness_social_media.fitness_social_media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness_social_media.fitness_social_media.models.User;
import com.fitness_social_media.fitness_social_media.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        User newUser=new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        User savedUser=userRepository.save(newUser);
        return savedUser;
    }

    @Override
    public User findUserById(Integer userId) throws Exception {
        java.util.Optional<User> user=userRepository.findById(userId);  
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("user not exist with user id " + userId);
    }

    @Override
    public User findUserByEmail(String email) {
        User user=userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User followUser(Integer userId1, Integer userId2) throws Exception {
        
        User user1=findUserById(userId1);
        User user2=findUserById(userId2);
        user2.getFollowers().add(user1.getId());
        user1.getFollowings().add(user2.getId());

        userRepository.save(user1);
        userRepository.save(user2);

        return user1;
    }

    @Override
    public User updateUser(User user,Integer userId) throws Exception {
        java.util.Optional<User> user1 = userRepository.findById(userId);
       if(user1.isEmpty()){
        throw new Exception("user not exised with id " + userId);
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

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

}
