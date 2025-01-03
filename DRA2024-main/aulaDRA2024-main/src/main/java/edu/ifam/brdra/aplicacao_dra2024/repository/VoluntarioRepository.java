package edu.ifam.brdra.aplicacao_dra2024.repository;

import edu.ifam.brdra.aplicacao_dra2024.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {

    Optional<Voluntario> findByPassaporte(String passaporte);
}

