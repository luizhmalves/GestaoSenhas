package br.com.gestaosenhas.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaosenhas.entidades.TiposSenhas;
import br.com.gestaosenhas.repositorios.TipoSenhaRepository;

@Service
public class TipoSenhaService {
	
	@Autowired
	public TipoSenhaRepository tpSenhaRepo;
	
	public TiposSenhas insereTpSenha(TiposSenhas tpSenha) {
		
		tpSenhaRepo.save(tpSenha);
		return tpSenha;
	}

	public List<TiposSenhas> buscaTodas() {
		return tpSenhaRepo.findAll();
	}
	
}
