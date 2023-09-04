package com.dan.jwt.web.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dan.jwt.service.ContatoService;
import com.dan.jwt.web.conversor.Conversor;
import com.dan.jwt.web.dto.ContatoRequestDto;
import com.dan.jwt.web.dto.ContatoResponseDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/contatos")
public class ContatoController {
    
    @Autowired
    private ContatoService contatoService;

    @Autowired
    private Conversor conversor;

    @GetMapping
    public ResponseEntity<?> findAll(Authentication authentication){

        String username = ((UserDetails)authentication.getPrincipal()).getUsername();


        ArrayList<ContatoResponseDto> contatos = conversor.contactToDto(contatoService.findAll(username));

        return ResponseEntity.ok().body(contatos);        
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ContatoRequestDto contato, Authentication authentication){
        
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();

        contatoService.save(conversor.dtoToContact(contato, username));
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        contatoService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody ContatoRequestDto contato, Authentication authentication){

        String username = ((UserDetails)authentication.getPrincipal()).getUsername();

        contatoService.edit(conversor.dtoToContact(contato, username));

        return ResponseEntity.ok().build();
    }



}
