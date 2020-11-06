package br.casadeshow.app.controller;

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
		service.inserir(banda);
		return ResponseEntity.status(HttpStatus.CREATED).body("banda inserido com sucesso!");
    }

	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Banda> bandas = service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(bandas);
    }


}
