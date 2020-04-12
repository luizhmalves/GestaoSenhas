package br.com.gestaosenhas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestaosenhas.entidades.TiposSenhas;

public interface TipoSenhaRepository extends JpaRepository<TiposSenhas, Long> {

}
