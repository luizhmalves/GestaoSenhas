package br.com.gestaosenhas.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.gestaosenhas.entidades.Senhas;
import br.com.gestaosenhas.servicos.SenhasService;

@Controller
public class SenhaControles {
	
	@Autowired
	private SenhasService senhaService;
	
	public Senhas insereSenha(Senhas senha) {
		return senhaService.insereSenha(senha);
	}
}
