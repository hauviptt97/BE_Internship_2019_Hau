package com.maven.springboot.blog.entities;

import lombok.Data;

import java.util.Set;

@Data
public class PostDto {

    private String content;

    private Set<Integer> tagIds;

}
