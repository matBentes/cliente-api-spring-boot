package com.api.api_user.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank(message = "CPF é obrigatório")
    @Column(name="cep")
    @Length(message="CPF com no máximo 8 caracteres",max=8)
    String CEP; 

    @Column(name="rua")
    @NotBlank(message = "Rua é obrigatório")
    @Length(message="Rua com no máximo 50 caracteres",max=50)
    String rua;

    @Column(name="bairro")
    @NotBlank(message = "bairro é obrigatório")
    @Length(message="Bairro com no máximo 50 caracteres",max=50)
    String bairro;

    @Column(name="numero")
    @NotBlank(message = "Número é obrigatório")
    String numero;

    @Column(name="cidade")
    @NotBlank(message = "Cidade é obrigatório")
    String cidade;

    @Column(name="uf")
    @NotBlank(message = "UF é obrigatório")
    @Length(message="UF com no máximo 2 caracteres",max=2)
    String UF;

    // @JoinColumn(name = "endereco")
    @OneToOne(mappedBy = "endereco")
    @JsonBackReference
    Cliente cliente;
}
