package br.com.gestaosenhas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestaosenhas.entidades.TiposUsuarios;

public interface TipoUsuarioRepository extends JpaRepository<TiposUsuarios, Long>{

}
