package br.com.gestaosenhas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestaosenhas.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
