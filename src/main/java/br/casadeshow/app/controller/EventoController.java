package br.casadeshow.app.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.casadeshow.app.model.Evento;
import br.casadeshow.app.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody Evento evento) {

		try {
			service.inserir(evento);
			return ResponseEntity.status(HttpStatus.CREATED).body("Evento inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {

		try {
			Iterable<Evento> evento = service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(evento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {

		try {
			Optional<Evento> evento = service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(evento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Evento evento, @PathVariable Long id) {
		try {
			service.atualizar(evento, id);
			return ResponseEntity.status(HttpStatus.OK).body("Evento atualizada com sucesso!");
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
