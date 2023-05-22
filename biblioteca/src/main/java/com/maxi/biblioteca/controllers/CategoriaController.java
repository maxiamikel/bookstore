package com.maxi.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.biblioteca.dtos.CategoriaDTO;
import com.maxi.biblioteca.models.Categoria;
import com.maxi.biblioteca.services.CategoriaService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService catService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = catService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @GetMapping(value = "/")
    public ResponseEntity<?> findAll(){
    	return catService.findAll();
    }
    
    
    @PostMapping( value = "/new")
    public ResponseEntity<?> create(@Valid @RequestBody Categoria obj){
    	return catService.create(obj);
    }
    
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody CategoriaDTO obj){
    	Categoria cat = catService.update(id, obj);
    	return ResponseEntity.ok().body(new CategoriaDTO(cat));
    }
    
    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
    	catService.delete(id);
    	return new ResponseEntity<String>("A categoria ["+id+"] foi deletado com sucesso", HttpStatus.OK);
    }
}
