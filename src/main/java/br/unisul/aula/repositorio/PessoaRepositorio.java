package br.unisul.aula.repositorio;

import br.unisul.aula.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

    Pessoa findPessoaByNome(String nome);

}
