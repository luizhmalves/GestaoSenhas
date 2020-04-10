package br.com.gestaosenhas.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Senhas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String formato;
	
	@ManyToOne
	@JoinColumn(name = "senha_tipo")
	private TiposSenhas tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public TiposSenhas getTipo() {
		return tipo;
	}

	public void setTipo(TiposSenhas tipo) {
		this.tipo = tipo;
	}
	
}
