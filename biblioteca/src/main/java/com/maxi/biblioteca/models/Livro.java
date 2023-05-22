package com.maxi.biblioteca.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "livros")
public class Livro implements Serializable {

    

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria-fk")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Long id, String titulo, String descricao, String idioma, String autor, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.idioma = idioma;
        this.autor = autor;
        this.categoria = categoria;
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

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

}
