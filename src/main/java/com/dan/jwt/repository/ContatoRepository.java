package com.dan.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.jwt.domain.Contato;


public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
}
