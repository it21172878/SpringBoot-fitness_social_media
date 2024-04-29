package com.fitness_social_media.fitness_social_media.service;

import java.util.List;

import com.fitness_social_media.fitness_social_media.models.Message;
import com.fitness_social_media.fitness_social_media.models.User;

public interface MessageService {
    public Message createMessage(User user,Integer chatId,Message req) throws Exception;
    public List<Message> findChatMessages(Integer chatId) throws Exception;

}
