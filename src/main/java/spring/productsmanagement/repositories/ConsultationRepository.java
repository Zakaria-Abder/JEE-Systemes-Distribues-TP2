package spring.productsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.productsmanagement.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}