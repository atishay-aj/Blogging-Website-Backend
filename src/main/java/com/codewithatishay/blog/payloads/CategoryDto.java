package com.codewithatishay.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int categoryId;

	@NotBlank
	@Size(min = 4, message = "min of 4 character")
	private String categoryTitle;
	@NotBlank
	@Size(min = 10, message = "min of 10 character")
	private String categoryDescription;
}
