package br.com.gestaosenhas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestaosenhas.entidades.Senhas;

@Repository
public interface SenhaRepositorio extends JpaRepository<Senhas, Long>{

}
