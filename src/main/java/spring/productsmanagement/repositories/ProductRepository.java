package spring.productsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.productsmanagement.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContains(String keyword);

}