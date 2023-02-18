package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {
    private long id;

    // not null or empty
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    // not null or empty
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    // not null or empty
    // should have at least 10 chars
    @NotEmpty
    @Size(min= 10, message = "Comment body should have at least 10 characters")
    private String body;

}
