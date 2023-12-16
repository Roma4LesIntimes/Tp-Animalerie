package fr.digi.animalerie;

import fr.digi.animalerie.entites.*;
import jakarta.persistence.*;

import java.util.Date;

public class App {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("animalerie");
             EntityManager em = emf.createEntityManager()) {


            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            // Création et persistance des objets Address
            Address address1 = new Address("10", "RUE JULES VERNE", "44000", "NANTES");
            Address address2 = new Address("11", "BOULEVARD SURCOUF", "44000", "NANTES");
            Address address3 = new Address("12", "ALLEE DE TURENNE", "44000", "NANTES");

            em.persist(address1);
            em.persist(address2);
            em.persist(address3);

            // Création et persistance des objets PetStore
            PetStore store1 = new PetStore(address1, "Store1", "manager1");
            PetStore store2 = new PetStore(address2, "Store2", "manager2");
            PetStore store3 = new PetStore(address3, "Store3", "manager3");

            em.persist(store1);
            em.persist(store2);
            em.persist(store3);

            // Création et persistance des objets Animal
            Fish fish1 = new Fish(new Date(), "blue", FishLivEnv.FRESH_WATER, store1);
            Fish fish2 = new Fish(new Date(), "red", FishLivEnv.SEA_WATER, store2);
            Fish fish3 = new Fish(new Date(), "green", FishLivEnv.FRESH_WATER, store2);
            Cat cat1 = new Cat(new Date(), "white", "chip1", store3);
            Cat cat2 = new Cat(new Date(), "black", "chip2", store2);
            Cat cat3 = new Cat(new Date(), "brown", "chip3", store3);

            em.persist(fish1);
            em.persist(fish2);
            em.persist(fish3);
            em.persist(cat1);
            em.persist(cat2);
            em.persist(cat3);

            // Création et persistance des objets Product en utilisant une autre méthode

            Product product1 = new Product();
            product1.setCode("code1");
            product1.setLabel("Food 1");
            product1.setType(ProdType.FOOD);
            product1.setPrice(10.5);
            product1.setStore(store1);

            Product product2 = new Product();
            product2.setCode("code2");
            product2.setLabel("Accessory 1");
            product2.setType(ProdType.ACCESSORY);
            product2.setPrice(5.0);
            product2.setStore(store2);

            Product product3 = new Product();
            product3.setCode("code3");
            product3.setLabel("Cleaning 1");
            product3.setType(ProdType.CLEANING);
            product3.setPrice(8.75);
            product3.setStore(store2);

            em.persist(product1);
            em.persist(product2);
            em.persist(product3);

            TypedQuery<Animal> queryAll = em.createQuery("from Animal a where a.store.id = 2", Animal.class);
            System.out.println(queryAll.getResultList());

            transaction.commit();

        }
    }
}