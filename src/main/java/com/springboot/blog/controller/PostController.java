package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create blog post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //get all posts api
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ) {

        return postService.getAllPosts(pageNum, pageSize, sortBy);
    }

    //get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //get post by id
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,
                                                  @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.updatePostById(postDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") long id) {
        //same as /return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);/
        postService.deletePostById(id);
        return ResponseEntity.ok("Post deleted successfully");
    }
}
