package br.com.gestaosenhas.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestaosenhas.entidades.Senhas;
import br.com.gestaosenhas.servicos.SenhasService;

@RestController
@RequestMapping({"/senhas"})
public class SenhaControles {
	
	@Autowired
	private SenhasService senhaService;
	
	@PostMapping()
	public Senhas insereSenha(@RequestBody Senhas senha) {
		return senhaService.insereSenha(senha);
	}
	
	@GetMapping()
	public List<Senhas> buscaTodas() {
		return senhaService.buscaTodas();
	}
	
	@PutMapping(value = "/{id}")
	public Senhas retornaProximaAtualizaAtual (@PathVariable("id") Long id, @RequestBody Senhas senha) {
		return senhaService.retornaProximaAtualizaAtual(id, senha);
		// Falta tratar excessões quando 
	}
}
