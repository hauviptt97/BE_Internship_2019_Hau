package com.maven.springboot.blog.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    @NotNull(message = "Tag name is a required field")
    private String name;

    @Column(name = "date_create")
    @CreatedDate
    private LocalDateTime dateCreate;

    @Column(name = "date_update")
    @LastModifiedDate
    private LocalDateTime dateUpdate;

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts;

}
