package fr.diginamic.cinemaspring.repositories;

import fr.diginamic.cinemaspring.models.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

    // Extraire tous les réalisateurs qui ont travaillé avec un acteur ou une actrice donnée.
    @Query("""
                SELECT DISTINCT r FROM Realisateur r
                JOIN r.films f
                JOIN f.casting a
                WHERE a.id = :idActeur
            """)
    List<Realisateur> findAllByActeurId(Long idActeur);
}
