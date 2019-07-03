package com.maven.springboot.blog.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    @NotNull(message = "Role name is a required field")
    private String name;

}