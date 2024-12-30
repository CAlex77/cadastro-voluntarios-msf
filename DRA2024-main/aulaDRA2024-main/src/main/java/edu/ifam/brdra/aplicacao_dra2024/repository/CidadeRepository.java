package edu.ifam.brdra.aplicacao_dra2024.repository;

import edu.ifam.brdra.aplicacao_dra2024.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("select c from Cidade c where c.nome = :nome")
    Cidade findByNome (@Param("nome") String nome);
}
