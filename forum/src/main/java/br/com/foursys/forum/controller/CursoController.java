package br.com.foursys.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.foursys.forum.controller.dto.CursoDto;
import br.com.foursys.forum.controller.form.AtualizarCursoForm;
import br.com.foursys.forum.controller.form.CursoForm;
import br.com.foursys.forum.model.Curso;
import br.com.foursys.forum.repository.CursoRepository;

/**
 * Classe responsável por controlar os processos de cursos do forum de dúvidas
 * @author Victor Baptista
 * @since 17/05/2021
 * @version 1.0
 */

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<CursoDto> lista() {
		List<Curso> cursos = cursoRepository.findAll();
		return CursoDto.converter(cursos);
	}
	
	@PostMapping
	public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoForm form, UriComponentsBuilder uriBuilder) {
		Curso curso = form.converter();
		cursoRepository.save(curso);
		
		URI uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).body(new CursoDto(curso));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CursoDto> detalhar(@PathVariable Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		if (curso.isPresent()) {
			return ResponseEntity.ok(new CursoDto(curso.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarCursoForm form) {
		Optional<Curso> optional = cursoRepository.findById(id);
		if (optional.isPresent()) {
			Curso curso = form.atualizar(id, cursoRepository);
			return ResponseEntity.ok(new CursoDto(curso));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Curso> optional = cursoRepository.findById(id);
		if (optional.isPresent()) {
			cursoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
