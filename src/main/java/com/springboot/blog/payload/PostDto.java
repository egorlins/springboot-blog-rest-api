package com.springboot.blog.payload;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Data
public class PostDto {
    private long id;

    // not null or empty
    // should have at least 2 chars
    @NotEmpty
    @Size(min= 2, message = "Post tittle should have at least 2 characters")
    private String title;

    // not null or empty
    // should have at least 10 chars
    @NotEmpty
    @Size(min= 10, message = "Post description should have at least 10 characters")
    private String description;

    // not null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    private long categoryId;
}
