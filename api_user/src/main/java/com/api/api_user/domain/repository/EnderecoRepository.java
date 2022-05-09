package com.api.api_user.domain.repository;

import com.api.api_user.domain.entity.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    
}
