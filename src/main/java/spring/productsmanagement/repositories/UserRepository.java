package spring.productsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.productsmanagement.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
}