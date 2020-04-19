package br.com.gestaosenhas.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestaosenhas.entidades.TiposSenhas;
import br.com.gestaosenhas.servicos.TipoSenhaService;

@RestController
@RequestMapping({"/tpsenhas"})
public class TipoSenhaControle {
	
	@Autowired
	private TipoSenhaService tpSenhaService;
	
	@PostMapping()
	public TiposSenhas insereSenha(@RequestBody TiposSenhas tpSenha) {
		return tpSenhaService.insereTpSenha(tpSenha);
	}
	
	@GetMapping()
	public List<TiposSenhas> buscaTodas() {
		return tpSenhaService.buscaTodas();
	}
	
}
