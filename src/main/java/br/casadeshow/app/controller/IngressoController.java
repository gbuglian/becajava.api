package br.casadeshow.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.casadeshow.app.model.Ingresso;
import br.casadeshow.app.service.IngressoService;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

	@Autowired
	private IngressoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody Ingresso ingresso) {

		try {
			service.inserir(ingresso);
			return ResponseEntity.status(HttpStatus.CREATED).body("Ingresso inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {

		try {
			Iterable<Ingresso> ingresso = service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(ingresso);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {

		try {
			Optional<Ingresso> ingresso = service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(ingresso);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Ingresso ingresso, @PathVariable Long id) {
		try {
			service.atualizar(ingresso, id);
			return ResponseEntity.status(HttpStatus.OK).body("Ingresso atualizada com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		try {
			service.deletar(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

}
