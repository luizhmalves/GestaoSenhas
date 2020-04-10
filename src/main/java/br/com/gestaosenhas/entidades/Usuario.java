package br.com.gestaosenhas.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, 
		       fetch = FetchType.LAZY, optional = true)
	private TiposUsuarios tipoUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TiposUsuarios getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TiposUsuarios tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
