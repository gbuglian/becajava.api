package br.casadeshow.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.CasaShow;
import br.casadeshow.app.repository.CasaShowRepository;

@Service
public class CasaShowService {
	
	
	@Autowired
	private CasaShowRepository _repository;
	
	public void inserir(CasaShow casaShow) {
		casaShow.setId(0L);
		_repository.save(casaShow);		
	}

	public List<CasaShow> listar(){	
		return _repository.findAll();
	}
}
