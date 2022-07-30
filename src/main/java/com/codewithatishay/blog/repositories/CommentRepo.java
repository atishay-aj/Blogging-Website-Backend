package com.codewithatishay.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithatishay.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
