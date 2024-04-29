package com.fitness_social_media.fitness_social_media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness_social_media.fitness_social_media.models.Story;

public interface StoryRepository extends JpaRepository<Story,Integer>{
    public List<Story> findByUserId(Integer userId);
}
