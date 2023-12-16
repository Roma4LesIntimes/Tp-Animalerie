package fr.digi.animalerie.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "cat")
public class Cat extends Animal {
    @Column(name = "chipid")
    private String chipid;

    public String getChipid() {
        return chipid;
    }

    public void setChipid(String chipid) {
        this.chipid = chipid;
    }

    // Constructeur par défaut requis par JPA
    public Cat() {
    }

    // Constructeur avec les paramètres nécessaires (y compris chipid)
    public Cat(Date birth, String couleur, String chipid, PetStore store) {
        super(birth, couleur, store);
        this.chipid = chipid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append(super.toStringSuper());
        sb.append(", chipid='").append(chipid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}