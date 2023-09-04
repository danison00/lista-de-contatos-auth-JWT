package com.dan.jwt.web.conversor;

import java.util.ArrayList;
import java.util.List;

import com.dan.jwt.domain.Contato;
import com.dan.jwt.web.dto.ContatoDto;

/**
 * Conversor
 */
public interface Conversor {

    Contato dtoToContact(ContatoDto contatoDto);

    ContatoDto contactToDto(Contato contato);

    ArrayList<ContatoDto> contactToDto(List<Contato> contatos);
    
}