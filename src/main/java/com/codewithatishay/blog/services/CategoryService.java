package com.codewithatishay.blog.services;

import java.util.List;

import com.codewithatishay.blog.payloads.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategory(CategoryDto categoryDto);

	public CategoryDto updateCategory(CategoryDto categoryDto, Integer Id);

	public void deleteCategory(Integer Id);

	public CategoryDto getCategory(Integer Id);

	public List<CategoryDto> getCategories();
}
