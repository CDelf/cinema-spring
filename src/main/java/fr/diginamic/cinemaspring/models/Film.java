package fr.diginamic.cinemaspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int annee;

    @NotNull(message = "Le champ idImdb ne peut pas être nul.")
    @Column(name="id_imdb", nullable = false)
    private String idImdb;

    private String langue;

    @NotNull(message = "Le champ nom ne peut pas être nul.")
    @Column(nullable = false)
    private String nom;

    private String rating;

    private String resume;

    @NotNull(message = "Le champ url ne peut pas être nul.")
    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name="id_lieu_tournage")
    private Lieu lieuTournage;

    @ManyToOne
    @JoinColumn(name="id_pays_origine")
    private Pays paysOrigine;

    @OneToMany(mappedBy = "film")
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "casting_principal",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_acteur")
    )
    private List<Acteur> casting = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "genre_film",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_genre")
    )
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "realisateur_film",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_realisateur")
    )
    private List<Realisateur> realisateurs = new ArrayList<>();

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getIdImdb() {
        return idImdb;
    }

    public void setIdImdb(String idImdb) {
        this.idImdb = idImdb;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Lieu getLieuTournage() {
        return lieuTournage;
    }

    public void setLieuTournage(Lieu lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    public Pays getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(Pays paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Acteur> getCasting() {
        return casting;
    }

    public void setCasting(List<Acteur> casting) {
        this.casting = casting;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }
}
