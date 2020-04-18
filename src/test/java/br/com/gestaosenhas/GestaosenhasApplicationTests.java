package br.com.gestaosenhas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gestaosenhas.controles.SenhaControles;
import br.com.gestaosenhas.entidades.Senhas;
import br.com.gestaosenhas.entidades.TiposSenhas;

@SpringBootTest
class GestaosenhasApplicationTests {
	
	Senhas senha = new Senhas();
	TiposSenhas tp = new TiposSenhas();
	
	@Autowired
	private SenhaControles senhas;
//	SenhaControles senhas = new SenhaControles();
	
	
	/*
	 * @Autowired Senhas senha;
	 * 
	 * @Autowired TiposSenhas tp;
	 */
	@Test
	void contextLoads() {
	}
	
	@Test
	void testaPadraoSenhaPreferencial() {
		
		tp.setId(0L);
		tp.setDescricao("Preferencial");
		senha.setAtendida(false);
		senha.setTipo(tp);
		senhas.insereSenha(senha);
		System.out.println(senha.toString());
	}
	
	@Test
	void testaPadraoSenhaNormal() {
		tp.setId(1L);
		tp.setDescricao("Normal");
		senha.setAtendida(false);
		senha.setTipo(tp);
		senhas.insereSenha(senha);
		System.out.println(senha.toString());
	}

}
