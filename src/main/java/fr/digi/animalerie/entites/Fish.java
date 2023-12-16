package fr.digi.animalerie.entites;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "fish")
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    @Column(name = "livingenv")
    private FishLivEnv livingenv;

    public FishLivEnv getLivingenv() {
        return livingenv;
    }

    public void setLivingenv(FishLivEnv livingenv) {
        this.livingenv = livingenv;
    }

    // Constructeur par défaut requis par JPA
    public Fish() {
    }

    public Fish(Date birth, String couleur, FishLivEnv livingenv, PetStore store) {
        super(birth, couleur, store);
        this.livingenv = livingenv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append(super.toStringSuper());
        sb.append(", livingenv='").append(livingenv).append('\'');
        sb.append('}');
        return sb.toString();
    }
}