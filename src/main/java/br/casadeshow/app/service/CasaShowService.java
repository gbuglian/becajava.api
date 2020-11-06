package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.CasaShow;
import br.casadeshow.app.repository.CasaShowRepository;

@Service
public class CasaShowService {
	
	
	@Autowired
	private CasaShowRepository _repository;
	
	public void inserir(CasaShow casaShow) {
		casaShow.setId(new Long (0));
		_repository.save(casaShow);		
	}

	public List<CasaShow> listar(){	
		return _repository.findAll();
	}
	
	public Optional<CasaShow> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(CasaShow casaShow,Long id) {
		casaShow.setId(id);
		_repository.save(casaShow);
	}

	public void deletar(Long id) {
		_repository.deleteById(id);
	}
	
}
