package br.com.gestaosenhas.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestaosenhas.servicos.SenhasService;

@RestController
@RequestMapping({"/contador"})
public class ContadorControles {
	
	@Autowired
	private SenhasService senhaService;
	
	@GetMapping({"/preferencial"})
	public String zeraContadorPreferencial() {
		senhaService.setContadorPreferencial(0);
		return "Contador de senhas preferenciais zerado com sucesso.";
	}
	
	@GetMapping({"/normal"})
	public String zeraContadorNormal() {
		senhaService.setContadorNormal(0);
		return "Contador de senhas normais zerado com sucesso.";
	}
}
