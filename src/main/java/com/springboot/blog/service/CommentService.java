package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

//    CommentResponse getAllComments(int pageNum, int pageSize,
//                             String sortBy, String sortDir);

      CommentDto getCommentById(long postId, long commentId);

//    CommentDto updateCommentById(CommentDto postDto, long id);

//    void deleteCommentById(long id);
}
