package com.fitness_social_media.fitness_social_media.service;

import java.util.List;

import com.fitness_social_media.fitness_social_media.models.Story;
import com.fitness_social_media.fitness_social_media.models.User;

public interface StoryService {
    public Story createStory(Story story,User user);
    public List<Story> findStoryByUserId(Integer userId) throws Exception;

}
