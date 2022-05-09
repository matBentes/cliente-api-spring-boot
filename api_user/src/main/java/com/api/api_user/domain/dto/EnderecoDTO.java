package com.api.api_user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    long id;
    String CEP; 
    String rua;
    String bairro; 
    String numero;
    String cidade;
    String UF; 
}
