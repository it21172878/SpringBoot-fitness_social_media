package com.fitness_social_media.fitness_social_media.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.PortResolver;

import com.fitness_social_media.fitness_social_media.models.Comment;
import com.fitness_social_media.fitness_social_media.models.Post;
import com.fitness_social_media.fitness_social_media.models.User;
import com.fitness_social_media.fitness_social_media.repository.CommentRepository;
import com.fitness_social_media.fitness_social_media.repository.PostRepository;

public class CommentServiceImplementation implements CommentService{

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {

        User user=userService.findUserById(userId);
        Post post=postService.findPostById(postId);

        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment=commentRepository.save(comment);
        post.getComments().add(savedComment);
        postRepository.save(post);
        return savedComment;
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        return null;
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) {
        return null;

    }

}
