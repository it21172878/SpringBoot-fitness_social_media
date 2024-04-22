package com.fitness_social_media.fitness_social_media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fitness_social_media.fitness_social_media.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

    @Query("select p from Post p where p.user.id=:userId")
    java.util.List<Post> findPostByUserId(Integer userId);

}
