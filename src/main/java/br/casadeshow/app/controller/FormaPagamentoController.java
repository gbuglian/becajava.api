package br.casadeshow.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.casadeshow.app.model.FormaPagamento;
import br.casadeshow.app.service.FormaPagamentoService;

@RestController
@RequestMapping("/FormasPagamentos")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody FormaPagamento formaPagamento) {

		try {
			service.inserir(formaPagamento);
			return ResponseEntity.status(HttpStatus.CREATED).body("Forma de Pagamento inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {

		try {
			Iterable<FormaPagamento> formaPagamento = service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(formaPagamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {

		try {
			Optional<FormaPagamento> formaPagamento = service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(formaPagamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody FormaPagamento formaPagamento, @PathVariable Long id) {
		try {
			service.atualizar(formaPagamento, id);
			return ResponseEntity.status(HttpStatus.OK).body("Forma de Pagamento atualizada com sucesso!");
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
