package com.api.api_user.controller;

import javax.validation.Valid;

import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.entity.Endereco;
import com.api.api_user.domain.service.EnderecoService;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping() //http://localhost:8080/cliente/
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto postMethodName(@Valid @RequestBody Endereco endereco) {
        return this.enderecoService.saveEndereco(endereco);
    }
}
