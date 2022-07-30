package com.codewithatishay.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.codewithatishay.blog.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min = 4, message = "Username must be of 4 characters !!")
	private String name;

	@Email(message = "Email not valid!!")
	private String email;

	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min = 8, max = 16, message = "Password must be min of 8 chars and max 16 chars")
	private String password;

	@NotEmpty
	private String about;

	private Set<RoleDto> roles = new HashSet<>();

}
