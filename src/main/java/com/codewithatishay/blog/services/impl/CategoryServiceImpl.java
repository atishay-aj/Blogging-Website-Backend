package com.codewithatishay.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithatishay.blog.entities.Category;
import com.codewithatishay.blog.payloads.CategoryDto;
import com.codewithatishay.blog.repositories.CategoryRepo;
import com.codewithatishay.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category addedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer Id) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(Id)
				.orElseThrow(() -> new EntityNotFoundException("Category not found"));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer Id) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(Id)
				.orElseThrow(() -> new EntityNotFoundException("Category not found"));
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategory(Integer Id) {
		// TODO Auto-generated method stub
		Category category = this.categoryRepo.findById(Id)
				.orElseThrow(() -> new EntityNotFoundException("Category not found"));

		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categories.stream()
				.map((category) -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());

		return categoryDtos;
	}

}
