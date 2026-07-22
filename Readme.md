# Activité Pratique N°2 - ORM JPA Hibernate Spring Data

## 1. Installer IntelliJ Ultimate

![Installation IntelliJ](Captures/Capture1.PNG)

---

## 2. Créer un projet Spring Initializer

Ajouter les dépendances :

- Spring Data JPA
- H2 Database
- Spring Web
- Lombok

![Spring Initializer](Captures/Capture1.PNG)

---

## 3. Créer l'entité JPA `Product`

L'entité contient les attributs suivants :

- `id` : Long
- `name` : String
- `price` : double
- `quantity` : int

![Entité Product](Captures/Capture2.PNG)

---

## 4. Configurer l'unité de persistance

Modifier le fichier **application.properties**.

![Configuration](Captures/Capture3.PNG)

---

## 5. Créer l'interface `ProductRepository`

Créer une interface basée sur **Spring Data JPA**.

![Repository](Captures/Capture4.PNG)

---

## 6. Tester les opérations CRUD

Les opérations réalisées sont :

- ✅ Ajouter des produits
- ✅ Consulter tous les produits
- ✅ Consulter un produit
- ✅ Rechercher des produits
- ✅ Modifier un produit
- ✅ Supprimer un produit

### Résultats

![CRUD 1](Captures/Capture5.PNG)

![CRUD 2](Captures/Capture8.PNG)

---

## 7. Migrer de H2 vers MySQL

### Base H2

![H2](Captures/Capture6.PNG)

### Base MySQL

![MySQL](Captures/Capture7.PNG)

---

## 8. Reprendre les exemples de la vidéo

Création des entités suivantes :

- Patient
- Médecin
- Rendez-vous
- Consultation
- Users
- Roles

![Projet](Captures/Capture9.PNG)
