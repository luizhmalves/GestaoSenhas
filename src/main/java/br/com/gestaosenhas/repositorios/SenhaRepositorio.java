package br.com.gestaosenhas.repositorios;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestaosenhas.entidades.Senhas;

@Repository
public interface SenhaRepositorio extends JpaRepository<Senhas, Long>{

    public List<Senhas> findByAtendida(Boolean atendida, Sort sort);
}
