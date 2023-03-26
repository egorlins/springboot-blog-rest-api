package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Schema(
        description = "PostDTO Model Information"
)
public class PostDtoV2 {
    private long id;

    @Schema(
            description = "Blog Post Tittle"
    )
    // not null or empty
    // should have at least 2 chars
    @NotEmpty
    @Size(min= 2, message = "Post tittle should have at least 2 characters")
    private String title;

    @Schema(
            description = "Blog Post Description"
    )
    // not null or empty
    // should have at least 10 chars
    @NotEmpty
    @Size(min= 10, message = "Post description should have at least 10 characters")
    private String description;

    @Schema(
            description = "Blog Post Content"
    )
    // not null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    @Schema(
            description = "Blog Post Category"
    )
    private long categoryId;
    private List<String> tags;
}
