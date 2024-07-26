package com.example.Loqo.Assignment.repository;

import com.example.Loqo.Assignment.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * ProductRepository used to perform CURD operation DB. Spring boot automatically creates the query for the methods
 * that we create in this.
 * @author Akshi Vasaniya
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}
