package com.fitness_social_media.fitness_social_media.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String caption;
    private String image1;
    private String image2;
    private String image3;
    private String video;
    
    @ManyToOne
    private User user;
    @OneToMany
    private List<User> liked=new ArrayList<>();
    private LocalDateTime createdAt;
    @OneToMany
    private List<Comment> comments=new ArrayList<>();

    public Post(){
        
    }

    

    public Post(Integer id, String caption, String image1, String image2, String image3, String video, User user,
            List<User> liked, LocalDateTime createdAt, List<Comment> comments) {
                super();
        this.id = id;
        this.caption = caption;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.video = video;
        this.user = user;
        this.liked = liked;
        this.createdAt = createdAt;
        this.comments = comments;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getLiked() {
        return liked;
    }

    public void setLiked(List<User> liked) {
        this.liked = liked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    

    // public Post(Integer id, String caption, String image, String video, User user, List<User> liked,
    //         LocalDateTime createdAt, List<Comment> comments) {
    //             super();
    //     this.id = id;
    //     this.caption = caption;
    //     this.image = image;
    //     this.video = video;
    //     this.user = user;
    //     this.liked = liked;
    //     this.createdAt = createdAt;
    //     this.comments = comments;
    // }

    // public Integer getId() {
    //     return id;
    // }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // public String getCaption() {
    //     return caption;
    // }

    // public void setCaption(String caption) {
    //     this.caption = caption;
    // }

    // public String getImage() {
    //     return image;
    // }

    // public void setImage(String image) {
    //     this.image = image;
    // }

    // public String getVideo() {
    //     return video;
    // }

    // public void setVideo(String video) {
    //     this.video = video;
    // }

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

    // public List<User> getLiked() {
    //     return liked;
    // }

    // public void setLiked(List<User> liked) {
    //     this.liked = liked;
    // }

    // public LocalDateTime getCreatedAt() {
    //     return createdAt;
    // }

    // public void setCreatedAt(LocalDateTime createdAt) {
    //     this.createdAt = createdAt;
    // }

    // public List<Comment> getComments() {
    //     return comments;
    // }

    // public void setComments(List<Comment> comments) {
    //     this.comments = comments;
    // }
    
}
