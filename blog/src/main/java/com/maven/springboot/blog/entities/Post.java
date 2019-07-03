package com.maven.springboot.blog.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "{post.title.notNull}")
    @Column(name = "title")
    private String title;

    @NotNull(message = "{post.content.notNull}")
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
