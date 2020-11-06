package br.casadeshow.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.casadeshow.app.model.Musico;
import br.casadeshow.app.service.MusicoService;

@RestController
@RequestMapping("/musicos")
public class MusicoController {

	@Autowired
	private MusicoService service;
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Musico musico) {
		
		try { 
				service.inserir(musico);
				return ResponseEntity.status(HttpStatus.CREATED).body("Musico inserido com sucesso!");
		} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");	
		}
	}

	@GetMapping
    public ResponseEntity listar() {		
		
		try {
				Iterable<Musico> bandas = service.listar();  		
				return ResponseEntity.status(HttpStatus.OK).body(bandas);
		} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");	
		}
    }
	
	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		
		try {
				Optional<Musico> musico = service.obter(id);
				return ResponseEntity.status(HttpStatus.OK).body(musico);
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
			}
	
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Musico musico, @PathVariable Long id) {
		try {
			service.atualizar(musico, id);
			return ResponseEntity.status(HttpStatus.OK).body("Musico atualizada com sucesso!");
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
