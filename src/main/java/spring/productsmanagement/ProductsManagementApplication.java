package spring.productsmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.productsmanagement.entities.Patient;
import spring.productsmanagement.entities.Product;
import spring.productsmanagement.repositories.PatientRepository;
import spring.productsmanagement.repositories.ProductRepository;

import java.util.Date;

public class ProductsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsManagementApplication.class, args);
    }


    CommandLineRunner start(ProductRepository productRepository,
                            PatientRepository patientRepository) {
        return args -> {

            productRepository.deleteAll();
            patientRepository.deleteAll();

            // ===========================
            // 1) Ajouter des produits
            // ===========================
            Product p1 = productRepository.save(new Product(null, "Ordinateur", 8000, 10));
            Product p2 = productRepository.save(new Product(null, "Imprimante", 2500, 5));
            Product p3 = productRepository.save(new Product(null, "Clavier", 300, 20));

            //===========================
            // Produits
            // ===========================
            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);

            // ===========================
            // 2) Consulter tous les produits
            // ===========================
            System.out.println("************* Tous les produits *************");
            productRepository.findAll().forEach(System.out::println);

            // ===========================
            // 3) Consulter un produit par ID
            // ===========================
            System.out.println("************* Produit avec ID = 1 *************");

            Product product = productRepository.findById(p1.getId()).get();

            System.out.println(product);

            // ===========================
            // 4) Chercher des produits
            // ===========================
            System.out.println("************* Recherche par nom *************");
            productRepository.findByNameContains("Ord").forEach(System.out::println);

            // ===========================
            // 5) Mettre à jour un produit
            // ===========================
            System.out.println("************* Mise à jour *************");
            Product productToUpdate = productRepository.findById(p2.getId()).get();

            productToUpdate.setPrice(3000);
            productRepository.save(productToUpdate);
            System.out.println(productToUpdate);

            // ===========================
            // 6) Supprimer un produit
            // ===========================
            System.out.println("************* Suppression P3 *************");

            productRepository.deleteById(p3.getId());
            System.out.println("Après suppression :");
            System.out.println("************* Liste des produits *************");
            productRepository.findAll().forEach(System.out::println);

            // ===========================
            // Patients
            // ===========================
            patientRepository.save(new Patient(
                    null,
                    "Ahmed",
                    new Date(),
                    true,
                    120
            ));

            patientRepository.save(new Patient(
                    null,
                    "Fatima",
                    new Date(),
                    false,
                    80
            ));

            patientRepository.save(new Patient(
                    null,
                    "Youssef",
                    new Date(),
                    true,
                    95
            ));

            System.out.println("************* Liste des patients *************");
            patientRepository.findAll().forEach(System.out::println);

        };
    }
}