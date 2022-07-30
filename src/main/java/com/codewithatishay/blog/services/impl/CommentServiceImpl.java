package com.codewithatishay.blog.services.impl;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithatishay.blog.entities.Comment;
import com.codewithatishay.blog.entities.Post;
import com.codewithatishay.blog.entities.User;
import com.codewithatishay.blog.payloads.CommentDto;
import com.codewithatishay.blog.repositories.CommentRepo;
import com.codewithatishay.blog.repositories.PostRepo;
import com.codewithatishay.blog.repositories.UserRepo;
import com.codewithatishay.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
		// TODO Auto-generated method stub

		User user = this.userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found"));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setUser(user);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new EntityNotFoundException("Comment not found"));
		this.commentRepo.delete(comment);

	}

}
