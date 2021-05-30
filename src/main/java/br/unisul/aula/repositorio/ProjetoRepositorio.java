package br.unisul.aula.repositorio;

import br.unisul.aula.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {
}
