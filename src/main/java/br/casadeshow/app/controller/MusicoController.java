package br.casadeshow.app.controller;

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
	private MusicoService _service;
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Musico musico) {	
		_service.inserir(musico);
		return ResponseEntity.status(HttpStatus.CREATED).body("Musico inserido com sucesso!");
    }

	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Musico> musicos = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(musicos);
    }
}
