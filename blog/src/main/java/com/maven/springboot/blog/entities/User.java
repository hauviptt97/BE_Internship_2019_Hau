package com.maven.springboot.blog.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "{user.email.notNull}")
    private String email;

    @NotNull(message = "{user.username.notNull}")
    @Size(min = 1, max = 50, message = "{user.username.size}")
    private String username;

    @Column(name = "password")
    @NotNull(message = "{user.password.notNull}")
    @Size(min = 1, max = 50, message = "{user.password.size}")
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