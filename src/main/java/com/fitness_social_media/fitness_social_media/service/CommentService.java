package com.fitness_social_media.fitness_social_media.service;

import com.fitness_social_media.fitness_social_media.models.Comment;

public interface CommentService {
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception;

    public Comment findCommentById(Integer commentId);
    
    public Comment likeComment(Integer commentId, Integer userId);


}
