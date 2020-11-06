package br.casadeshow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casadeshow.app.model.Localizacao;
import br.casadeshow.app.service.LocalizacaoService;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoService _service;
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Localizacao localizacao) {	
		_service.inserir(localizacao);
		return ResponseEntity.status(HttpStatus.CREATED).body("Localização inserido com sucesso!");
    }

	@GetMapping
    public ResponseEntity listar() {		
		Iterable<Localizacao> localizacaos = _service.listar();  		
    	return ResponseEntity.status(HttpStatus.OK).body(localizacaos);
    }
}
