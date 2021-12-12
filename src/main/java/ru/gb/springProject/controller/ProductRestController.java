package ru.gb.springProject.controller;

import org.springframework.web.bind.annotation.*;
import ru.gb.springProject.dto.Product;
import ru.gb.springProject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/iShop/rest")
public class ProductRestController {
    private ProductService productService;

    public ProductRestController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){ return productService.getAll();}

    @GetMapping("/info/{id}")
    public Product getProoductInfo(@PathVariable Integer id){
        return productService.findById(id);
    }

    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product){
        productService.save(product);
        return product;
    }

    @GetMapping("/del/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
    }


}
