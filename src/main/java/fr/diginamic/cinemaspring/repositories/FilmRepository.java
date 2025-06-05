package fr.diginamic.cinemaspring.repositories;

import fr.diginamic.cinemaspring.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    //    Extraire tous les films pour une année donnée. L’extraction doit être paginée.
    Page<Film> findAllByAnnee(int annee, Pageable pageable);

    Page<Film> findAllByAnneeBetween(int before, int after, Pageable pageable);

    //    Extraire un film en fonction de son identifiant
    Optional<Film> findById(Long id);

    //   Extraire tous les films communs à 2 acteurs donnés.
    @Query("""
                SELECT f FROM Film f 
                JOIN f.casting a1 
                JOIN f.casting a2 
                WHERE a1.id = :idActeur1 AND a2.id = :idActeur2
            """)
    List<Film> findCommonFilmsBetweenTwoActeurs(Long idActeur1, Long idActeur2);

    // Extraire tous les films d’un pays donné. L’extraction doit être paginée.
    Page<Film> findAllByPaysOrigineId(Long idPays, Pageable pageable);

    // Extraire tous les films d’un réalisateur/réalisatrice donné.
    List<Film> findAllByRealisateursId(Long idRealisateur);


}
