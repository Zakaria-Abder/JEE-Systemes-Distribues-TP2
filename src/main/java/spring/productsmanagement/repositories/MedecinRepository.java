package spring.productsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.productsmanagement.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}