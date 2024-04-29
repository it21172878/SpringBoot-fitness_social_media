package com.fitness_social_media.fitness_social_media.service;

import com.fitness_social_media.fitness_social_media.exceptions.UserException;
import com.fitness_social_media.fitness_social_media.models.User;

public interface UserService {
    public User registerUser(User user);
    public User findUserById(Integer userId) throws UserException;
    public User findUserByEmail(String email);
    public User followUser(Integer userId1,Integer userId2) throws UserException;
    public User updateUser(User user,Integer userId) throws UserException;
    public java.util.List<User> searchUser(String query);
    public User findUserByJwt(String jwt);
}
