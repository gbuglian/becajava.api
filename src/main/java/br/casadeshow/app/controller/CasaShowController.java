package br.casadeshow.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.casadeshow.app.model.*;
import br.casadeshow.app.service.*;

@RestController
@RequestMapping("/casasdeshow")
public class CasaShowController {

	@Autowired
	private CasaShowService service;
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody CasaShow casaShow) {
		
		try { 
				service.inserir(casaShow);
				return ResponseEntity.status(HttpStatus.CREATED).body("Casa de Show inserido com sucesso!");
		} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");	
		}
	}

	@GetMapping
    public ResponseEntity listar() {		
		
		try {
				Iterable<CasaShow> bandas = service.listar();  		
				return ResponseEntity.status(HttpStatus.OK).body(bandas);
		} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");	
		}
    }
	
	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		
		try {
				Optional<CasaShow> casaShow = service.obter(id);
				return ResponseEntity.status(HttpStatus.OK).body(casaShow);
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
			}
	
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody CasaShow casaShow, @PathVariable Long id) {
		try {
			service.atualizar(casaShow, id);
			return ResponseEntity.status(HttpStatus.OK).body("Casa de Show atualizada com sucesso!");
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
