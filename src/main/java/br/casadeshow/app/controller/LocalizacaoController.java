package br.casadeshow.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casadeshow.app.model.Localizacao;
import br.casadeshow.app.service.LocalizacaoService;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoService service;
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody Localizacao localizacao) {
		
		try { 
				service.inserir(localizacao);
				return ResponseEntity.status(HttpStatus.CREATED).body("Localização inserido com sucesso!");
		} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");	
		}
	}

	@GetMapping
    public ResponseEntity listar() {		
		
		try {
				Iterable<Localizacao> bandas = service.listar();  		
				return ResponseEntity.status(HttpStatus.OK).body(bandas);
		} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");	
		}
    }
	
	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		
		try {
				Optional<Localizacao> localizacao = service.obter(id);
				return ResponseEntity.status(HttpStatus.OK).body(localizacao);
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
			}
	
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Localizacao localizacao, @PathVariable Long id) {
		try {
			service.atualizar(localizacao, id);
			return ResponseEntity.status(HttpStatus.OK).body("Localização atualizada com sucesso!");
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
