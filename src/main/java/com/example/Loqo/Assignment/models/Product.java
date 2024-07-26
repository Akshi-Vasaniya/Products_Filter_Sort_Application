package com.example.Loqo.Assignment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Product class refer to has document in MongoDB. Group of documents is know has collections.
 * @author Akshi Vasaniya
 */
@Document(collection = "Products")
public class Product {
    @Id
    String id;
    @Field("name")
    String name;
    @Field("category")
    String category;
    @Field("price")
    Double price;
    @Field("inStock")
    boolean inStock;
    @Field("rating")
    Double rating;
    @Field("createdAt")
    Date createdAt;

    // Constructor
    public Product(String id, String name, String category, Double price, boolean inStock, Double rating, Date createdAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.inStock = inStock;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
