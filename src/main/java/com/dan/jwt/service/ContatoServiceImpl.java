package com.dan.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dan.jwt.domain.Contato;
import com.dan.jwt.repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public void save(Contato contato) {
        
        contatoRepository.save(contato);
    }

    @Override
    public List<Contato> findAll(String username) {
        
        return contatoRepository.findAllContact(username);
    }

    @Override
    public void deleteById(Long id) {
        
        contatoRepository.deleteById(id);
    }

    @Override
    public void edit(Contato contato) {

        contatoRepository.save(contato);
    }

}
