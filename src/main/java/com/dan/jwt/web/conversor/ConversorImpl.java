package com.dan.jwt.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dan.jwt.domain.Contato;
import com.dan.jwt.web.dto.ContatoDto;

@Component
public class ConversorImpl implements Conversor {
    
    @Override
    public Contato dtoToContact(ContatoDto contatoDto){

        return new Contato(contatoDto.getId(), contatoDto.getNome(), contatoDto.getNumero(), contatoDto.getEmail());

    }

    @Override
    public ContatoDto contactToDto(Contato contato) {

        return new ContatoDto(contato.getId(), contato.getNome(), contato.getNumero(), contato.getEmail());

    }

    @Override
    public ArrayList<ContatoDto> contactToDto(List<Contato> contatos) {

        var contactsDto = new ArrayList<ContatoDto>();

        contatos.forEach(contact -> contactsDto.add(new ContatoDto(
                contact.getId(),
                contact.getNome(),
                contact.getNumero(),
                contact.getEmail())));

        return contactsDto;

    }
}
