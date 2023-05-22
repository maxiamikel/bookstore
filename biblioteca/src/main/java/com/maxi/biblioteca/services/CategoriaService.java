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

import com.maxi.biblioteca.dtos.CategoriaDTO;
import com.maxi.biblioteca.models.Categoria;
import com.maxi.biblioteca.repositories.CategoriaRepository;
import com.maxi.biblioteca.services.exceptions.ObjetoNoEncontradoException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRepo;

	public Categoria findById(Long id) {
		Optional<Categoria> obj = catRepo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNoEncontradoException(
				"O codigo: " + id + " da " + Categoria.class.getSimpleName() + " informado não foi encontrado"));
	}

	public ResponseEntity<?> findAll() {
		List<Categoria> lista = catRepo.findAll();
		List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		if (listaDTO.size() == 0) {
			String msg = "Sem conteudo para exibir [Lista vazia]";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		return ResponseEntity.ok().body(listaDTO);
	}

	public boolean verifyIfExistsCategoryNome(String nome) {
		List<Categoria> lista = catRepo.findByNome(nome);
		return lista.isEmpty();
	}

	public ResponseEntity<?> create(Categoria obj) {
		if (verifyIfExistsCategoryNome(obj.getNome())) {
			obj.setId(null);
			Categoria categoria = catRepo.save(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
					.toUri();
			return ResponseEntity.created(uri).body(new CategoriaDTO(categoria));
		} else {
			return new ResponseEntity<String>("O objeto:" + obj.getClass().getSimpleName() + " com o nome: "
					+ obj.getNome() + " informado já existe", HttpStatus.CONFLICT);
		}

	}

	public Categoria update(Long id, CategoriaDTO obj) {

		Categoria cat = findById(id);
		cat.setDescricao(obj.getDescricao());
		cat.setNome(obj.getNome());
		return catRepo.saveAndFlush(cat);
	}

	public void delete(Long id) {
		findById(id);
		try {
			catRepo.deleteById(id);
		} catch (Exception e) {
			throw new com.maxi.biblioteca.services.exceptions.DataIntegrityViolationExceptions("Não foi possivel deletar essa categoris, pois tem livros associados");
		}

	}
}
