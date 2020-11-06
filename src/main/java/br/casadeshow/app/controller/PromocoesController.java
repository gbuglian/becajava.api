package br.casadeshow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casadeshow.app.model.Promocoes;
import br.casadeshow.app.service.PromocoesService;

@RestController
@RequestMapping("/promocoes")
public class PromocoesController {

	@Autowired
	private PromocoesService service;
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Promocoes promocoes) {	
		service.inserir(promocoes);
		return ResponseEntity.status(HttpStatus.CREATED).body("Promoção inserida com sucesso!");
    }

	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Promocoes> promocoess = service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(promocoess);
    }
}
