package com.codewithatishay.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codewithatishay.blog.config.AppConstants;
import com.codewithatishay.blog.entities.Role;
import com.codewithatishay.blog.repositories.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.passwordEncoder.encode("12345"));

		try {
			Role role = new Role(AppConstants.ADMIN_USER, "ROLE_ADMIN");
			Role role1 = new Role(AppConstants.NORMAL_USER, "ROLE_NORMAL");
			List<Role> roles = List.of(role, role1);
			this.roleRepo.saveAll(roles);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
