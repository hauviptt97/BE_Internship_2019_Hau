package com.maven.springboot.blog.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "date_create")
    @CreatedDate
    private LocalDateTime dateCreate;

    @Column(name = "date_update")
    @LastModifiedDate
    private LocalDateTime dateUpdate;

    @ManyToMany
    @JoinTable(name = "tag_post",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
