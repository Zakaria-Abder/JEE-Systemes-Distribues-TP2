package spring.productsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.productsmanagement.entities.RendezVous;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}