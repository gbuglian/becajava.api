package br.casadeshow.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.Evento;
import br.casadeshow.app.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository _repository;

	public void inserir(Evento evento) {
		evento.setId(new Long(0));
		_repository.save(evento);
	}

	public List<Evento> listar() {
		return _repository.findAll();
	}

	public Optional<Evento> obter(Long id) {
		return _repository.findById(id);
	}

	public void atualizar(Evento evento, Long id) {
		evento.setId(id);
		_repository.save(evento);
	}

	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
