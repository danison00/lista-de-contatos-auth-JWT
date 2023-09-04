package com.dan.jwt.web.conversor;

import java.util.ArrayList;
import java.util.List;

import com.dan.jwt.domain.Contato;
import com.dan.jwt.web.dto.ContatoRequestDto;
import com.dan.jwt.web.dto.ContatoResponseDto;

/**
 * Conversor
 */
public interface Conversor {

    Contato dtoToContact(ContatoRequestDto contatoDto, String username);

    ContatoResponseDto contactToDto(Contato contato);

    ArrayList<ContatoResponseDto> contactToDto(List<Contato> contatos);
    
}