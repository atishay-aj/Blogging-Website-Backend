package com.codewithatishay.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithatishay.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
