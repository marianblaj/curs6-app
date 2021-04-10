package ro.fastrackit.curs6.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fastrackit.curs6.entity.Product;
import ro.fastrackit.curs6.enums.Category;
import ro.fastrackit.curs6.exceptions.ResourceNotFoundException;
import ro.fastrackit.curs6.service.ProductService.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    private final ProductService service;

    @GetMapping("/all")
    List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping()
    List<Product> getProducts(@RequestParam("category") String category, @RequestParam("maxPrice") int maxPrice){
        var result = service.getProductsByCategoryMaxPrice(category, maxPrice);
        if(result.isEmpty())
            throw new ResourceNotFoundException("No products found for that filters.");
        else return result;
    }

    @GetMapping("/{productId}")
    Product getProductId(@PathVariable("productId") int productId){
       return service.getProductId(productId)
               .orElseThrow(() -> new ResourceNotFoundException("No product found for that ID"));
    }

    @PostMapping(path = "/")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        service.deleteProduct(productId);
    }
}
