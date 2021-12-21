package ru.gb.springProject.repository;

import org.springframework.stereotype.Component;
import ru.gb.springProject.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productsList;

    @PostConstruct
    public void init(){
        productsList = new ArrayList<>();
        productsList.add(new Product(1, "Молоко", 90));
        productsList.add(new Product(2, "Батон", 40));
        productsList.add(new Product(3, "Геркулес", 43));
        productsList.add(new Product(4, "Масло", 185));
    }

    public List<Product> getAll(){
        return List.copyOf(productsList);
    }

    public Product findById(int id){
        return productsList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public void deleteById(int id){
        productsList.stream().filter(product -> product.getId() == id).findFirst().ifPresent(productsList::remove);
    }

    public void save(Product product){
        productsList.add(product);
    }
}
