package ro.fastrackit.curs6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fastrackit.curs6.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
