package br.casadeshow.app.controller;

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
		service.inserir(casaShow);
		return ResponseEntity.status(HttpStatus.CREATED).body("Casa de Show inserido com sucesso!");
    }

	@GetMapping
    public ResponseEntity listar() {		
		Iterable<CasaShow> casaShows = service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(casaShows);
    }
}
