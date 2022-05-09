package com.api.api_user.domain.service;


import com.api.api_user.domain.dto.ResponseDto;

import java.util.List;
import java.util.stream.Collectors;

import com.api.api_user.domain.dto.EnderecoDTO;
import com.api.api_user.domain.entity.Endereco;
import com.api.api_user.domain.enumeration.Status;
import com.api.api_user.domain.repository.EnderecoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto; 

    EnderecoRepository enderecoRepository;

    public ResponseDto saveEndereco(Endereco endereco) {
        responseDto.setId(enderecoRepository.save(endereco).getId());
        responseDto.setMenssage("Endereco incluido com sucesso");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<EnderecoDTO> getAllEnderecos() {
        List<EnderecoDTO> listAllClients = enderecoRepository.findAll().stream().map(Cliente -> modelMapper.map(Cliente, EnderecoDTO.class)).collect(Collectors.toList());
        return listAllClients;
    }

    public EnderecoDTO getClienteById(Long id) {
        return modelMapper.map(enderecoRepository.findById(id).get(), EnderecoDTO.class);
    }

    public ResponseDto updateCliente(Endereco endereco) {
        // responseDto.setId(userRepository.save(user).getId());
        if (endereco.getId() > 0) {
            this.enderecoRepository.findById(endereco.getId()).get();
            enderecoRepository.save(endereco);
            responseDto.setMenssage("Endereco alterado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Endereco inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ResponseDto deleteUser(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            enderecoRepository.deleteById(id);
            responseDto.setMenssage("Endereco deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Endereco inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }
}
