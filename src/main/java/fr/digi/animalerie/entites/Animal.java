package fr.digi.animalerie.entites;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "couleur")
    private String couleur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STORE", referencedColumnName = "id")
    private PetStore store;


    public long getId() {
        return id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getStore() {
        return store;
    }

    public void setStore(PetStore store) {
        if (null != this.store) {
            this.store.getAnimals().remove(this);
        }
        this.store = store;
        if (null != this.store) {
            this.store.getAnimals().add(this);
        }
    }


    // Constructeur avec les paramètres nécessaires (y compris chipid en option)
    protected Animal(Date birth, String couleur, PetStore store) {
        this.birth = birth;
        this.couleur = couleur;
        setStore(store);
    }

    protected Animal() {
    }

    protected String toStringSuper() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append(toStringSuper());
        sb.append('}');
        return sb.toString();
    }
}