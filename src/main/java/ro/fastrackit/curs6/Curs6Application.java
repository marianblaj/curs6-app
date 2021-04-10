package ro.fastrackit.curs6;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fastrackit.curs6.entity.Product;
import ro.fastrackit.curs6.enums.Category;
import ro.fastrackit.curs6.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class Curs6Application {

	public static void main(String[] args) {
		SpringApplication.run(Curs6Application.class, args);
	}


	@Bean
	CommandLineRunner atStartup(ProductRepository repository) {
		return args -> {
			repository.saveAll(List.of(
					new Product("product1", 11, "produsul nr 1", Category.CATEGORY1),
					new Product("product2", 22, "produsul nr 2", Category.CATEGORY2),
					new Product("product3", 33, "produsul nr 3", Category.CATEGORY3),
					new Product("product4", 44, "produsul nr 4", Category.CATEGORY4),
					new Product("product4", 44, "produsul nr 4", Category.CATEGORY4)
			));
		};
	}
}
