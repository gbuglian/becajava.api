package br.casadeshow.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.Promocoes;
import br.casadeshow.app.repository.PromocoesRepository;

@Service
public class PromocoesService {
	
	
	@Autowired
	private PromocoesRepository _repository;
	
	public void inserir(Promocoes promocoes) {
		promocoes.setId(0L);
		_repository.save(promocoes);		
	}

	public List<Promocoes> listar(){	
		return _repository.findAll();
	}
}
