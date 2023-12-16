# Animalerie Project

## Description
Le projet Animalerie est une application de gestion d'une animalerie. Il permet de suivre les magasins d'animaux, les adresses, les animaux, et les produits disponibles dans ces magasins.

## Technologies utilisées
- Java
- Jakarta Persistence API (JPA)
- Hibernate
- MariaDB (ou tout autre système de gestion de base de données compatible JPA)

## Configuration

1. **Base de données**

   Assurez-vous d'avoir une instance MariaDB (ou tout autre système de gestion de base de données) installée et en cours d'exécution. Vous devrez créer une base de données pour le projet et configurer les informations de connexion dans le fichier `persistence.xml`.

2. **Configurer persistence.xml**

   Modifiez le fichier `src/META-INF/persistence.xml` avec les informations de votre base de données (les fichiers sont configurés pour une base de données nommée 'animalerie'.

3. **Exécuter l'application**

   Compilez et exécutez le projet à l'aide de votre IDE ou des commandes Maven.

## Choix de conception

Pour Address j'aurais pu choisir d'utiliser '@Embeddedid' et '@Embeddable' mais j'ai cru comprendre que ce qui était attendu était d'appliquer la relation '@OneToOne'.
Pour simplifier l'insertion j'ai créé des constructeurs supplémentaires pour Fish, Cat, PetStore, Address, pour Product, j'ai utilisé les méthodes setXXX comme dans les exemples vus en cours.
