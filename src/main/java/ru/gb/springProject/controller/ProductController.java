package ru.gb.springProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springProject.dto.Product;
import ru.gb.springProject.service.ProductService;

@Controller
@RequestMapping("/iShop")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "product_list";
    }

    @GetMapping("/info/{id}")
    public String getProductInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    @GetMapping("/add")
    public String getProductAddFrom() {
        return "product_form";
    }

    @PostMapping("/add")
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:/all";
    }

    @PostMapping("/delete/{id}")
    public String saveProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return "redirect:/all";
    }
}
