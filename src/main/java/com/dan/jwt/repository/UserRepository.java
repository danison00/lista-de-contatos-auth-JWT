package com.dan.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.dan.jwt.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

    UserDetails findByEmail(String email);
}
