package com.maxi.biblioteca.dtos;

import com.maxi.biblioteca.models.Categoria;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoriaDTO {

    private Long id;

    @NotEmpty(message = "O nome não deve ser vazio")
    @Size(max = 200, min = 6, message = "Informe um nome valido")
    private String nome;

    @NotEmpty(message = "A descricao não deve ser vazia")
    @Size(max = 2000, min = 6, message = "Informe uma descrição valida")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
}
