package br.casadeshow.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.casadeshow.app.model.Banda;
import br.casadeshow.app.service.BandaService;

@RestController
@RequestMapping("/bandas")
public class BandaController {

	@Autowired
	private BandaService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody Banda banda) {

		try {
			service.inserir(banda);
			return ResponseEntity.status(HttpStatus.CREATED).body("Banda inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {

		try {
			Iterable<Banda> bandas = service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(bandas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {

		try {
			Optional<Banda> banda = service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Banda banda, @PathVariable Long id) {
		try {
			service.atualizar(banda, id);
			return ResponseEntity.status(HttpStatus.OK).body("Banda atualizada com sucesso!");
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


