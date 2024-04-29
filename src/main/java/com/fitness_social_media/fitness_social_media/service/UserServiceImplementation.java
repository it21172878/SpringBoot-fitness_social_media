package com.fitness_social_media.fitness_social_media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness_social_media.fitness_social_media.config.JwtProvider;
import com.fitness_social_media.fitness_social_media.exceptions.UserException;
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
    public User findUserById(Integer userId) throws UserException {
        java.util.Optional<User> user=userRepository.findById(userId);  
        if(user.isPresent()){
            return user.get();
        }
        throw new UserException("user not exist with user id " + userId);
    }

    @Override
    public User findUserByEmail(String email) {
        User user=userRepository.findByEmail(email);
        return user;
    }

    @Override
    public User followUser(Integer reqUserId, Integer userId2) throws UserException {
        
        User reqUser=findUserById(reqUserId);
        User user2=findUserById(userId2);
        user2.getFollowers().add(reqUser.getId());
        reqUser.getFollowings().add(user2.getId());

        userRepository.save(reqUser);
        userRepository.save(user2);

        return reqUser;
    }

    @Override
    public User updateUser(User user,Integer userId) throws UserException {
        java.util.Optional<User> user1 = userRepository.findById(userId);
       if(user1.isEmpty()){
        throw new UserException("user not exised with id " + userId);
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
       if(user.getGender()!=null){
        oldUser.setGender(user.getGender());
       }

       User updateUser=userRepository.save(oldUser);

       return updateUser;
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

    @Override
    public User findUserByJwt(String jwt) {
        
        String email=JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email);
        return user;
    }

}
