package org.example.controller;

import org.exemple.data.ProductDto;
import org.exemple.ports.api.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServicePort productServicePort;

    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productServicePort.addProduct(productDto);
    }

    @GetMapping("/get/{id}")
    public ProductDto getProductByID(@PathVariable long id) {
        return productServicePort.getProductById(id);
    }

    @GetMapping("/get")
    public List<ProductDto> getAllProducts() {
        return productServicePort.getProducts();
    }

}
