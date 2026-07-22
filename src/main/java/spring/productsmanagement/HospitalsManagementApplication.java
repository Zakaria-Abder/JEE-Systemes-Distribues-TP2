package spring.productsmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.productsmanagement.repositories.PatientRepository;
import spring.productsmanagement.entities.Consultation;
import spring.productsmanagement.entities.Medecin;
import spring.productsmanagement.entities.Patient;
import spring.productsmanagement.entities.Product;
import spring.productsmanagement.entities.RendezVous;
import spring.productsmanagement.repositories.ProductRepository;
import spring.productsmanagement.service.IHospitalService;

import java.util.Date;

@SpringBootApplication
public class HospitalsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalsManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, IHospitalService hospitalService) {

            return args -> {

                // ==========================
                // PRODUITS
                // ==========================

                Product pr1 = productRepository.save(
                        new Product(null, "Ordinateur", 8000, 10)
                );

                Product pr2 = productRepository.save(
                        new Product(null, "Imprimante", 2500, 5)
                );

                Product pr3 = productRepository.save(
                        new Product(null, "Clavier", 300, 20)
                );

                //System.out.println("=========== PRODUITS ===========");

               // productRepository.findAll()    .forEach(System.out::println);

                // ==========================
                // PATIENTS
                // ==========================

                Patient p1 = hospitalService.savePatient(
                        new Patient(null, "Ahmed", new Date(), true, 120)
                );

                Patient p2 = hospitalService.savePatient(
                        new Patient(null, "Fatima", new Date(), false, 80)
                );

                // ==========================
                // MEDECINS
                // ==========================

                Medecin m1 = hospitalService.saveMedecin(
                        new Medecin(
                                null,
                                "Dr Hassan",
                                "hassan@gmail.com",
                                "Cardiologue"
                        )
                );

                Medecin m2 = hospitalService.saveMedecin(
                        new Medecin(
                                null,
                                "Dr Amal",
                                "amal@gmail.com",
                                "Dentiste"
                        )
                );

                // ==========================
                // RENDEZ-VOUS
                // ==========================

                RendezVous rdv1 = hospitalService.saveRendezVous(
                        new RendezVous(
                                null,
                                new Date(),
                                "PENDING",
                                p1,
                                m1
                        )
                );

                RendezVous rdv2 = hospitalService.saveRendezVous(
                        new RendezVous(
                                null,
                                new Date(),
                                "DONE",
                                p2,
                                m2
                        )
                );

                // ==========================
                // CONSULTATIONS
                // ==========================

                hospitalService.saveConsultation(
                        new Consultation(
                                null,
                                new Date(),
                                "Consultation générale",
                                rdv1
                        )
                );

                hospitalService.saveConsultation(
                        new Consultation(
                                null,
                                new Date(),
                                "Contrôle annuel",
                                rdv2
                        )
                );

                // ==========================
                // AFFICHAGE
                // ==========================

                System.out.println("\n=========== PATIENTS ===========");
                hospitalService.listPatients()
                        .forEach(System.out::println);

                System.out.println("\n=========== MEDECINS ===========");
                hospitalService.listMedecins()
                        .forEach(System.out::println);

                System.out.println("\n=========== RENDEZ-VOUS ===========");
                hospitalService.listRendezVous()
                        .forEach(System.out::println);

                System.out.println("\n=========== CONSULTATIONS ===========");
                hospitalService.listConsultations()
                        .forEach(System.out::println);
            };
        }
}
