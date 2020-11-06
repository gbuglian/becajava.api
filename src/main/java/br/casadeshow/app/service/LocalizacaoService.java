package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.model.Localizacao;
import br.casadeshow.app.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
	
	
	@Autowired
	private LocalizacaoRepository _repository;
	
	public void inserir(Localizacao localizacao) {
		localizacao.setId(new Long (0));
		_repository.save(localizacao);		
	}

	public List<Localizacao> listar(){	
		return _repository.findAll();
	}
	
	public Optional<Localizacao> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Localizacao localizacao,Long id) {
		localizacao.setId(id);
		_repository.save(localizacao);
	}

	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
