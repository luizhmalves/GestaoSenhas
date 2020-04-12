package br.com.gestaosenhas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaosenhas.entidades.Senhas;
import br.com.gestaosenhas.repositorios.SenhaRepositorio;

@Service
public class SenhasService {
	
	private Integer contadorPreferencial = 0;
	private Integer contadorNormal = 0;
	
	@Autowired
	private SenhaRepositorio senhaRepositorio; 
	
	/**
	 * O parâmetro de entrada refere-se ao objeto senha recebido do front-end no qual indicará
	 * valor 0 para senha preferencial ou valor 1 para senha normal, para posterior
	 * inserção no banco de dados.
	 * Setando um formato de senha de seis dígitos com prefixo P para senha preferencial ou 
	 * prefixo N para senha normal.
	 * @param senha
	 */
	public Senhas insereSenha(Senhas senha) {
		if (senha.getTipo().getId().equals(0L)) {
			String senhaFormatoAux = String.format("%06d", this.contadorPreferencial);
			senha.setFormato("P"+senhaFormatoAux);
			senha.setAtendida(false);
			this.contadorPreferencial++;
		} else {
			String senhaFormatoAux = String.format("%06d", this.contadorNormal);
			senha.setFormato("N"+senhaFormatoAux);
			senha.setAtendida(false);
			this.contadorPreferencial++;
		}
		senhaRepositorio.save(senha);
		return senha;
	}
}
