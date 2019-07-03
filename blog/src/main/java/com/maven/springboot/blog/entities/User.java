package com.maven.springboot.blog.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "date_create")
    @CreatedDate
    private LocalDateTime dateCreate;

    @Column(name = "date_update")
    @LastModifiedDate
    private LocalDateTime dateUpdate;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}