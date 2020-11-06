package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.Ingresso;
import br.casadeshow.app.repository.IngressoRepository;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository _repository;

	public void inserir(Ingresso ingresso) {
		ingresso.setId(new Long(0));
		_repository.save(ingresso);
	}

	public List<Ingresso> listar() {
		return _repository.findAll();
	}

	public Optional<Ingresso> obter(Long id) {
		return _repository.findById(id);
	}

	public void atualizar(Ingresso ingresso, Long id) {
		ingresso.setId(id);
		_repository.save(ingresso);
	}

	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}
