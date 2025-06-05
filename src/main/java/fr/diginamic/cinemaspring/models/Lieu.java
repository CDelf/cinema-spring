package fr.diginamic.cinemaspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le champ region ne peut pas être nul.")
    @Column(nullable = false)
    private String region;

    @NotNull(message = "Le champ ville ne peut pas être nul.")
    @Column(nullable = false)
    private String ville;

    @ManyToOne
    @JoinColumn(name="id_pays")
    private Pays pays;

    @OneToMany(mappedBy = "lieuNaissance")
    private List<Acteur> acteurs = new ArrayList<>();

    @OneToMany(mappedBy = "lieuTournage")
    private List<Film> films = new ArrayList<>();

    public Lieu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
