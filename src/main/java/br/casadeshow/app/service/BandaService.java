package br.casadeshow.app.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.casadeshow.app.model.Banda;
import br.casadeshow.app.repository.BandaRepository;

@Service
public class BandaService {
		
	@Autowired
	private BandaRepository _repository;
	
	public void inserir(Banda banda) {
		banda.setId(0L);
		_repository.save(banda);		
	}

	public List<Banda> listar(){	
		return _repository.findAll();
	}

}
