package ro.fastrackit.curs6.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fastrackit.curs6.entity.Product;
import ro.fastrackit.curs6.enums.Category;
import ro.fastrackit.curs6.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public List<Product> getProductsByCategoryMaxPrice(String category, int maxPrice) {
        return repository.findAll().stream()
                .filter(product -> product.getCategory().name().equalsIgnoreCase(category))
                .filter(product -> product.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }

    public Optional<Product> getProductId(int productId) {
        return repository.findAll().stream()
                .filter(product -> product.getId() == productId)
                .findFirst();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(Long productId) {
        repository.deleteById(productId);
    }
}
