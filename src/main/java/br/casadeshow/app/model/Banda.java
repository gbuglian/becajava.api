package br.casadeshow.app.model;

import javax.persistence.*;

@Entity
public class Banda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	private String Estilo;
	
	@ManyToOne
	@JoinColumn(name = "CasaShowId")
	private CasaShow casaShow;
	
	@ManyToOne
	@JoinColumn(name = "LocalizacaoId")
	private Localizacao localizacao;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEstilo() {
		return Estilo;
	}
	public void setEstilo(String estilo) {
		Estilo = estilo;
	}
}
