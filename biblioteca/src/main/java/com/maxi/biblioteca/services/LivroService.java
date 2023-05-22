package com.maxi.biblioteca.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.biblioteca.dtos.LivroDTO;
import com.maxi.biblioteca.models.Livro;
import com.maxi.biblioteca.repositories.LivroRepository;
import com.maxi.biblioteca.services.exceptions.ObjetoNoEncontradoException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LivroService {

	@Autowired
	private LivroRepository livRepo;

	public Livro findById(Long id) {
		Optional<Livro> obj = livRepo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNoEncontradoException(
				"O codigo: " + id + " do " + Livro.class.getSimpleName() + " informado não foi encontrado"));
	}

	public ResponseEntity<?> findAll() {
		List<Livro> lista = livRepo.findAll();
		List<LivroDTO> listaDTO = lista.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		if (listaDTO.size() == 0) {
			String msg = "Sem conteudo para exibir [Lista vazia]";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		return ResponseEntity.ok().body(listaDTO);
	}
	
	public boolean verifyIfExistsLivroTitulo(String titulo) {
		List<Livro> lista = livRepo.findByTitulo(titulo);
		return lista.isEmpty();
	}

	public ResponseEntity<?> create(Livro obj) {
		if(verifyIfExistsLivroTitulo(obj.getTitulo())) {
			obj.setId(null);
			Livro livro = livRepo.save(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(new LivroDTO(livro));
		}else {
			return new ResponseEntity<String>("O objeto:"+obj.getClass().getSimpleName()+" com o titulo: "+obj.getTitulo()+" informado já existe", HttpStatus.CONFLICT);
		}
		
	}

	public Livro update(Long id, LivroDTO obj) {

		Livro livro = findById(id);
		livro.setAutor(obj.getAutor());
		livro.setDescricao(obj.getDescricao());
		livro.setIdioma(obj.getIdioma());
		livro.setTitulo(obj.getTitulo());
		return livRepo.saveAndFlush(livro);
	}
	
	public void delete(Long id) {
		Livro obj = findById(id);
		livRepo.delete(obj);
	}
}
