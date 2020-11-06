package br.casadeshow.app.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.casadeshow.app.model.Banda;
import br.casadeshow.app.repository.BandaRepository;

@Service
public class BandaService {
		
	@Autowired
	private BandaRepository _repository;
	
	public void inserir(Banda banda) {
		banda.setId(new Long (0));
		_repository.save(banda);		
	}

	public List<Banda> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Banda> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Banda banda,Long id) {
		banda.setId(id);
		_repository.save(banda);
	}

	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
