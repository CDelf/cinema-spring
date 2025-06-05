package fr.diginamic.cinemaspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_naissance")
    private LocalDate dateNaissance;

    @NotNull(message = "Le champ idImdb ne peut pas être nul.")
    @Column(name="id_imdb", nullable = false)
    private String idImdb;

    @Column(nullable = false)
    private String identite;

    private String taille;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name="id_lieu_naissance")
    private Lieu lieuNaissance;

    @OneToMany(mappedBy = "acteur")
    List<Role> roles = new ArrayList<>();

    @ManyToMany(mappedBy = "casting")
    List<Film> films = new ArrayList<>();

    public Acteur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(String idImdb) {
        this.idImdb = idImdb;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Lieu getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(Lieu lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
