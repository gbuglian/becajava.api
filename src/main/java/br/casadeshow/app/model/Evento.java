package br.casadeshow.app.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
//	private double Valor;

	@ManyToOne
	@JoinColumn(name = "IdCasaShow")
	public CasaShow CasaShow;

	@ManyToOne
	@JoinColumn(name = "IdLocalizacao")
	public Localizacao Localizacao;

	@ManyToOne
	@JoinColumn(name = "IdBanda")
	public Banda Banda;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

//	public double getValor() {
//		return Valor;
//	}
//
//	public void setValor(double valor) {
//		Valor = valor;
//	}

	public CasaShow getCasaShow() {
		return CasaShow;
	}

	public void setCasaShow(CasaShow casaShow) {
		CasaShow = casaShow;
	}

	public Localizacao getLocalizao() {
		return Localizacao;
	}

	public void setLocalizao(Localizacao localizacao) {
		Localizacao = localizacao;
	}

	public Banda getBanda() {
		return Banda;
	}

	public void setBanda(Banda banda) {
		this.Banda = banda;
	}
}
