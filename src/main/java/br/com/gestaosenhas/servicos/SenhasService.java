package br.com.gestaosenhas.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
			this.contadorNormal++;
		}
		senhaRepositorio.save(senha);
		return senha;
	}

	public List<Senhas> buscaTodas() {
		return senhaRepositorio.findByAtendida(false, Sort.by(Sort.Direction.ASC,"tipo"));
	}
	
	/**
	 * Método para retornar próxima senha e atualizar próxima como já atendida,
	 * caso seja necessário chamar a primeira senha o id de envio será o zero.
	 * @param id idenficador a senha a ser atualizada.
	 * @param senha objeto que será atualizado.
	 * @return próximo objeto senha a ser atendido.
	 */

	public Senhas retornaProximaAtualizaAtual(Long id, Senhas senha) {
		Senhas atualizada = null;
		if (!id.equals(0L)) {
			atualizada = senhaRepositorio.findById(id).get();
			atualizada.setAtendida(true);
			atualizada.setFormato(senha.getFormato());
			atualizada.setId(id);
			atualizada.setTipo(senha.getTipo());
			senhaRepositorio.save(atualizada);
		}
		
		List<Senhas> senhas = this.buscaTodas();
		if (senhas.isEmpty() || senhas == null) {
			return null;
		}
		return senhas.get(0);
	}

	public void setContadorPreferencial(Integer contadorPreferencial) {
		this.contadorPreferencial = contadorPreferencial;
	}

	public void setContadorNormal(Integer contadorNormal) {
		this.contadorNormal = contadorNormal;
	}
	
	public Integer getContadorPreferencial() {
		return contadorPreferencial;
	}
	
	public Integer getContadorNormal() {
		return contadorNormal;
	}
	
}
