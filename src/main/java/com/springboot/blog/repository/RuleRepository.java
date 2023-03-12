package com.springboot.blog.repository;

import com.springboot.blog.entity.Role;
import com.springboot.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RuleRepository  extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String email);
}
