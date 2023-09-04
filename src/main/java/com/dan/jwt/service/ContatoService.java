package com.dan.jwt.service;

import java.util.List;

import com.dan.jwt.domain.Contato;

public interface ContatoService {

    void save(Contato contato);
    
    void deleteById(Long id);

    void edit(Contato contato);

    List<Contato> findAll(String username);
}
