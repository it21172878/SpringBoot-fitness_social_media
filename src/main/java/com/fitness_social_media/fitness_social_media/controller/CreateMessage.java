package com.fitness_social_media.fitness_social_media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fitness_social_media.fitness_social_media.models.Message;
import com.fitness_social_media.fitness_social_media.models.User;
import com.fitness_social_media.fitness_social_media.service.MessageService;
import com.fitness_social_media.fitness_social_media.service.UserService;

@RestController
public class CreateMessage {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@RequestBody Message req,@RequestHeader("Authorization") String jwt, @PathVariable Integer chatId) throws Exception{
        User user=userService.findUserByJwt(jwt);
        Message message=messageService.createMessage(user, chatId, req);
        return message;
    }
    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> createMessage(@RequestHeader("Authorization") String jwt, @PathVariable Integer chatId) throws Exception{
        User user=userService.findUserByJwt(jwt);
        List<Message> message=messageService.findChatMessages(chatId);
        return message;
    }

}
