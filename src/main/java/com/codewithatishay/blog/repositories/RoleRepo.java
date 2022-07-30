package com.codewithatishay.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithatishay.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
