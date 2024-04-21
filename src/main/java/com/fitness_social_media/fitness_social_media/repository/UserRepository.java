package com.fitness_social_media.fitness_social_media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness_social_media.fitness_social_media.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
