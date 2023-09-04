package com.dan.jwt.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.dan.jwt.domain.Contato;
import com.dan.jwt.domain.User;
import com.dan.jwt.repository.UserRepository;
import com.dan.jwt.web.dto.ContatoRequestDto;
import com.dan.jwt.web.dto.ContatoResponseDto;

@Component
public class ConversorImpl implements Conversor {

    @Autowired
    private UserRepository repository;
    
    @Override
    public Contato dtoToContact(ContatoRequestDto contatoDto, String username){

        User user = (User)repository.findByUsername(username);

        return new Contato(contatoDto.getId(), contatoDto.getNome(), contatoDto.getNumero(), contatoDto.getEmail(), user);

    }

    @Override
    public ContatoResponseDto contactToDto(Contato contato) {

        return new ContatoResponseDto(contato.getId(), contato.getNome(), contato.getNumero(), contato.getEmail());

    }

    @Override
    public ArrayList<ContatoResponseDto> contactToDto(List<Contato> contatos) {

        var contactsDto = new ArrayList<ContatoResponseDto>();

        contatos.forEach(contact -> contactsDto.add(new ContatoResponseDto(
                contact.getId(),
                contact.getNome(),
                contact.getNumero(),
                contact.getEmail())));

        return contactsDto;

    }
}
