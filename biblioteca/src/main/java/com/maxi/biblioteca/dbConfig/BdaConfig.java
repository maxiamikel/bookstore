package com.maxi.biblioteca.dbConfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxi.biblioteca.models.Categoria;
import com.maxi.biblioteca.models.Livro;
import com.maxi.biblioteca.repositories.CategoriaRepository;
import com.maxi.biblioteca.repositories.LivroRepository;

@Configuration
public class BdaConfig {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    

    @Bean
    public void inicializarBD(){
        
    	Categoria c1 = new Categoria(null, "Informatica", "Coleção dos livros informaticos");
        Categoria c2 = new Categoria(null, "Medicina", "Coleção dos livros medicina moderna");
        Categoria c3 = new Categoria(null, "Ingenharia Civil", "Coleção dos livros da ingehnaria civil e arquitetura urbanista");

        Livro l1 = new Livro(null, "Java, como pprogramar ", "Programação detaalhada e avanzada com java", "Porgugues", "Dietel", c1);
        Livro l2 = new Livro(null, "Guia para programar ", "Programação detaalhada e avanzada com java", "Porgugues", "Dietel", c1);
        Livro l3 = new Livro(null, "Medicina moderna ", "Anatomia humana e nutrição", "Porgugues", "Hebert", c2);

        categoriaRepository.saveAll(Arrays.asList(c1,c2, c3));

        livroRepository.saveAll(Arrays.asList(l1,l2,l3));
    }
    
}
