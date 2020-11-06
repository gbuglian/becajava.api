package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.FormaPagamento;
import br.casadeshow.app.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository _repository;

	public void inserir(FormaPagamento formaPagamento) {
		formaPagamento.setId(new Long(0));
		_repository.save(formaPagamento);
	}

	public List<FormaPagamento> listar() {
		return _repository.findAll();
	}

	public Optional<FormaPagamento> obter(Long id) {
		return _repository.findById(id);
	}

	public void atualizar(FormaPagamento formaPagamento, Long id) {
		formaPagamento.setId(id);
		_repository.save(formaPagamento);
	}

	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
