package ru.gb.springProject.service;

import org.springframework.stereotype.Service;
import ru.gb.springProject.dto.Product;
import ru.gb.springProject.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Product findById(int id){
        return productRepository.findById(id);
    }

    public void deleteById(int id){
         productRepository.deleteById(id);
    }

    public void save(Product product){
         productRepository.save(product);
    }
}
