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

import com.maxi.biblioteca.dtos.LivroDTO;
import com.maxi.biblioteca.models.Livro;
import com.maxi.biblioteca.services.LivroService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/livros")
public class Livrocontroller {

	@Autowired
	private LivroService livService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro obj = livService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/")
	public ResponseEntity<?> findAll() {
		return livService.findAll();
	}

	@PostMapping(value = "/new")
	public ResponseEntity<?> create(@Valid @RequestBody Livro obj) {
		return livService.create(obj);
	}

	@PatchMapping(value = "/edit/{id}")
	public ResponseEntity<?> update( @PathVariable Long id,@Valid @RequestBody LivroDTO obj) {
		Livro cat = livService.update(id, obj);
		return ResponseEntity.ok().body(new LivroDTO(cat));
	}

	@DeleteMapping(value = "/del/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		livService.delete(id);
		return new ResponseEntity<String>("O livro [" + id + "] foi deletado com sucesso", HttpStatus.OK);
	}
}
