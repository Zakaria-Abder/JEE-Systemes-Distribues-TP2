package spring.productsmanagement.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String email;

    private String specialite;


    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;


    public Medecin() {
    }


    public Medecin(Long id, String nom, String email, String specialite) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.specialite = specialite;
    }


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialite() {
        return specialite;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }


    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}