package spring.productsmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.productsmanagement.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}