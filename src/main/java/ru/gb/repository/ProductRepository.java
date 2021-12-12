package ru.gb.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.gb.dto.Product;

@Component
public class ProductRepository {

  private List<Product> productsList;

  @PostConstruct
  public void init() {
    productsList = new ArrayList<>();
    productsList.add(new Product(1, "Молоко", 90));
    productsList.add(new Product(2, "Батон", 40));
    productsList.add(new Product(3, "Геркулес", 43));
    productsList.add(new Product(3, "Масло", 185));
  }

  public List<Product> getAllProducts() {
    return List.copyOf(productsList);
  }

  public void addProduct(Product product) { productsList.add(product); }

  public Product findById(int id) {
    return productsList.stream().filter(product -> product.getId() == id)
        .findFirst()
        .orElse(null);
  }
}
