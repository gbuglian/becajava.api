package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.Musico;
import br.casadeshow.app.repository.MusicoRepository;

@Service
public class MusicoService {
		
	@Autowired
	private MusicoRepository _repository;
	
	public void inserir(Musico musico) {
		musico.setId(new Long (0));
		_repository.save(musico);		
	}

	public List<Musico> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Musico> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Musico musico,Long id) {
		musico.setId(id);
		_repository.save(musico);
	}

	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}
