package com.maxi.biblioteca.dtos;

import com.maxi.biblioteca.models.Livro;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LivroDTO {

    private Long id;

    @NotEmpty(message = "O titulo é requerido")
    @Size(max = 200, min = 6, message ="O titulo deve conter entre 6 - 200 caracteres")
    private String titulo;

	@NotEmpty(message = "O descricao é requerido")
    @Size(max = 200, min = 6, message ="O descricao deve conter entre 6 - 200 caracteres")
    private String descricao;

	@NotEmpty(message = "O idioma é requerido")
    @Size(max = 90, min = 4, message ="O idioma deve conter entre 4 - 90 caracteres")
    private String idioma;

	@NotEmpty(message = "O nome do autor é requerido")
    @Size(max = 200, min = 6, message ="O nome do autor deve conter entre 6 - 200 caracteres")
    private String autor;
    

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.descricao = obj.getDescricao();
        this.idioma = obj.getIdioma();
        this.autor = obj.getAutor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

 
    
}
