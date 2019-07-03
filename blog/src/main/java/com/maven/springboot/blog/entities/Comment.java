package com.maven.springboot.blog.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @EmbeddedId
    CommentKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @MapsId("post_id")
    @JoinColumn(name="post_id")
    private Post post;

    @Column(name = "content")
    private String content;

    @Column(name = "date_create")
    @CreatedDate
    private LocalDateTime dateCreate;

    @Column(name = "date_update")
    @LastModifiedDate
    private LocalDateTime dateUpdate;
}
