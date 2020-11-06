package br.casadeshow.app.model;

import javax.persistence.*;

@Entity
public class Promocoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Data;
	private Double Valor;
	private String Tipo;
	
	@ManyToOne
	@JoinColumn(name = "CasaShowId")
	private CasaShow CasaShow;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public CasaShow getCasaShow() {
		return CasaShow;
	}
	public void setCasaShow(CasaShow casaShow) {
		this.CasaShow = casaShow;
	}
}
