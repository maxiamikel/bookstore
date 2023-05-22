package com.maxi.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.biblioteca.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	List<Livro> findByTitulo(String titulo);
    
}
