package com.example.Loqo.Assignment.controller;

import com.example.Loqo.Assignment.models.Product;
import com.example.Loqo.Assignment.repository.ProductRepository;
import com.example.Loqo.Assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * ProductController class represent the Mapping for request and response. It has /products endpoint to filter and sort
 * the product based on multiple parameters.
 * @author Akshi Vasaniya
 */
@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * This method is used to insert the product into the database.
     * @param product product info
     * @return return the added product info
     */
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        product.setCreatedAt(new Date());
        Product product1 = productService.addProduct(product);
        return ResponseEntity.ok(product1);
    }

    /**
     * This method is used to get the all products from the database.
     * @return all the products in
     */
    @GetMapping("/get")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * This method is used to fetch the products by applying some filter and sort.
     * @param category product category
     * @param minPrice min price
     * @param maxPrice max price
     * @param inStock product in stock
     * @param sortField sort by which field
     * @param sortOrder ASC or DSC
     * @return returns the sorted and filtered products
     * @throws Exception throws exception if something is invalid
     */
    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(defaultValue = "createdAt") String sortField,
            @RequestParam(defaultValue = "ASC") String sortOrder
    ) throws Exception {
        return productService.getFilterAndSortProduct(category, minPrice, maxPrice, inStock, sortField, sortOrder);
    }
}
