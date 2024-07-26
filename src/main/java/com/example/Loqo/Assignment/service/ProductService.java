package com.example.Loqo.Assignment.service;


import com.example.Loqo.Assignment.models.Product;
import com.example.Loqo.Assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductService class represent the core logic to fetch the products by applying filters and sort. We have use Query
 * class for filtering and sorting using multiple parameters. And for CURD we can simply use ProductRepository.
 * @author Akshi Vasaniya
 */
@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Add new product in Db
     * @param product new product details
     * @return added product details
     */
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Fetch all the products from DB.
     * @return all the products in db.
     */
    public List<Product> getAllProducts() {
        List<Product> li = productRepository.findAll();
        System.out.println(li);
        return li;
    }

    /**
     * This method contains the logic to filter and sort the product based on properties.
     * @param category product category
     * @param minPrice min price
     * @param maxPrice max price
     * @param inStock product available in stock
     * @param sortField sort field
     * @param sortOrder sort order
     * @return filter and sorted products
     * @throws Exception if something is invalid
     */
    public List<Product> getFilterAndSortProduct(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField,
                                          String sortOrder) throws Exception {
        try{
            Query query = new Query();
            /*Filtering*/
            if (category != null && !category.isEmpty()) { // filter by category
                query.addCriteria(Criteria.where("category").is(category));
            }
            if (minPrice != null && maxPrice != null) { // filter by price
                query.addCriteria(Criteria.where("price").gte(minPrice).lte(maxPrice));
            } else if (minPrice != null) {
                query.addCriteria(Criteria.where("price").gte(minPrice));
            } else if (maxPrice != null) {
                query.addCriteria(Criteria.where("price").lte(maxPrice));
            }
            if (inStock != null) { // filter by stock
                query.addCriteria(Criteria.where("inStock").is(inStock));
            }

            /*Sorting*/
            if (sortField != null && !sortField.isEmpty()) { // sort by field and order.
                if (sortOrder != null) {
                    query.with(Sort.by(Sort.Direction.fromString(sortOrder), sortField));
                } else {
                    query.with(Sort.by(Sort.Direction.ASC, sortField));
                }
            } else {
                query.with(Sort.by(Sort.Direction.ASC, "createdAt"));
            }

            return mongoTemplate.find(query, Product.class);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
