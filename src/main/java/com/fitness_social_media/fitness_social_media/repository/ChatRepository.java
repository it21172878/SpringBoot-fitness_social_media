package com.fitness_social_media.fitness_social_media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fitness_social_media.fitness_social_media.models.Chat;
import com.fitness_social_media.fitness_social_media.models.User;

public interface ChatRepository extends JpaRepository<Chat, Integer>{

    public List<Chat> findByUsersId(Integer userId);
    @Query("select c from Chat c Where :user Member of c.users And :reqUser Member of c.users")
    public Chat findChatByUsersId(@Param("user") User user,@Param("reqUser") User reqUser);

}
