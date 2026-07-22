package spring.productsmanagement.web;

import org.springframework.web.bind.annotation.*;
import spring.productsmanagement.entities.Product;
import spring.productsmanagement.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Consulter tous les produits
    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Consulter un produit par son ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Rechercher des produits par nom
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productRepository.findByNameContains(keyword);
    }

    // Ajouter un produit
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Modifier un produit
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {

        product.setId(id);
        return productRepository.save(product);
    }

    // Supprimer un produit
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}