package com.codewithatishay.blog.services;

import java.util.List;

import com.codewithatishay.blog.payloads.PostDto;
import com.codewithatishay.blog.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String orderBy);

	PostDto getPostById(Integer postId);

	PostResponse getAllByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);

	PostResponse getAllByUser(Integer userId, Integer pageNumber, Integer pageSize);

	List<PostDto> searchPosts(String keyword);

}
