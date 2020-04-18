package br.com.gestaosenhas.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TiposSenhas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipo")
	private List<Senhas> senhas = new ArrayList<Senhas>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Senhas> getSenhas() {
		return senhas;
	}

	public void setSenhas(List<Senhas> senhas) {
		this.senhas = senhas;
	}
	
}
