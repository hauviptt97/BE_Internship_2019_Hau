package com.maven.springboot.blog.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CommentKey implements Serializable {

    @Column(name = "comment_id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "post_id")
    private int postId;
}
