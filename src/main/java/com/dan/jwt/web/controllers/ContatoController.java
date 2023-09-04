package com.dan.jwt.web.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dan.jwt.service.ContatoService;
import com.dan.jwt.web.conversor.Conversor;
import com.dan.jwt.web.dto.ContatoDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/contatos")
public class ContatoController {
    
    @Autowired
    private ContatoService contatoService;

    @Autowired
    private Conversor conversor;

    @GetMapping
    public ResponseEntity<?> findAll(){

        ArrayList<ContatoDto> contatos = conversor.contactToDto(contatoService.findAll());

        return ResponseEntity.ok().body(contatos);        
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ContatoDto contato){

        contatoService.save(conversor.dtoToContact(contato));
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        contatoService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody ContatoDto contato){

        contatoService.edit(conversor.dtoToContact(contato));

        return ResponseEntity.ok().build();
    }



}
