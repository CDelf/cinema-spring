package fr.diginamic.cinemaspring.repositories;

import fr.diginamic.cinemaspring.models.Acteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    // Retourner tous les acteurs ayant un nom donné
    List<Acteur> findAllByIdentiteIgnoreCase(String identite);

    // Extraire tous les acteurs/actrices ayant joué dans un film donné
    List<Acteur> findAllByFilmsId(Long id);

    // Extraire tous les acteurs et actrices nés dans un pays donné et pour une année
    //donnée. L’extraction doit être paginée.
    Page<Acteur> findAllByLieuNaissancePaysIdAndDateNaissance(
            Long idPays, LocalDate dateNaissance, Pageable pageable);
}
