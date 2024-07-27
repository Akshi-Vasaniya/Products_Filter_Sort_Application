# Summary

This Spring Boot project demonstrates how to create a RESTful API for managing and querying a MongoDB collection of products. The application provides functionality for filtering and sorting product records based on various criteria.

**Key Components and Functionality:**
1. Product Model:
   - The Product class represents the product schema with fields such as name, category, price, inStock, rating, and createdAt.
   - Annotated with @Document to map the class to the MongoDB collection products
2. ProductRepository:
   - The ProductRepository interface extends MongoRepository, providing basic CRUD operations for Product entities.
   - Custom query methods can be added if needed.
3. ProductService:
   - The ProductService class handles the business logic for filtering and sorting products.
   - Uses MongoTemplate for dynamic query construction, allowing flexible and complex filtering based on the provided parameters.
   - Contains methods for CRUD operations using ProductRepository.
4. ProductController:
   - The ProductController class exposes RESTful endpoints for interacting with products.
   - Provides endpoints to get filtered and sorted products, save a new product, delete a product, get a product by ID, and fetch all products.
  

# Filter By
- Price
- Category
- InStock

# Sort By
- Price
- Rating
- CreatedAt

# Getting Started
To run the application:
1. Fork and Clone the repository
   ```
   https://github.com/Akshi-Vasaniya/Products_Filter_Sort_Application.git
   ```
2. Import the Project in IDE
3. Configure the MongoDB connection in application.properties
   ```
   spring.data.mongodb.host=[hostname]
   spring.data.mongodb.port=[portnumber]
   spring.data.mongodb.database=[DBname]
   spring.data.mongodb.uri=mongodb://[hostname]:[portnumber]/[DBname]
   ```
4. Build the project
   ```
   mvn clean install
   ```
5. Run the application
6. Check the logs for any errors
7. Access the application
   ```
   HTTP://[hostname]:[portnumber]
   ```

# Example Usage
- Endpoint: `GET /products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc`
- Description: Fetch filter and sorted products according to user needs.
- Response:
  ```
  [
    {
        "id": "66a2910ba38d6468b38d44e0",
        "name": "TV",
        "category": "electronics",
        "price": 299.99,
        "inStock": true,
        "rating": 4.5,
        "createdAt": "2024-07-25T17:53:15.053+00:00"
    },
    {
        "id": "66a29156a38d6468b38d44e1",
        "name": "Smartphone",
        "category": "electronics",
        "price": 299.99,
        "inStock": true,
        "rating": 4.5,
        "createdAt": "2024-07-25T17:54:30.926+00:00"
    }
  ]
  ```

**Get All Products**
- Endpoint: `GET /get`
- Description: Fetch all products from the database
- Response:
  ```
  [
    {
        "id": "66a2910ba38d6468b38d44e0",
        "name": "TV",
        "category": "electronics",
        "price": 299.99,
        "inStock": true,
        "rating": 4.5,
        "createdAt": "2024-07-25T17:53:15.053+00:00"
    },
    {
        "id": "66a29156a38d6468b38d44e1",
        "name": "Smartphone",
        "category": "electronics",
        "price": 299.99,
        "inStock": true,
        "rating": 4.5,
        "createdAt": "2024-07-25T17:54:30.926+00:00"
    },
    {
        "id": "66a29166a38d6468b38d44e2",
        "name": "Laptop",
        "category": "electronics",
        "price": 899.99,
        "inStock": true,
        "rating": 4.7,
        "createdAt": "2024-07-25T17:54:46.157+00:00"
    }
  ]
  ```

**Add Product**
- Endpoint: `POST /add`
- Description: Add new product into the database
- Request:
  ```
  {
    "name": "Laptop",
    "category": "electronics",
    "price": 899.99,
    "inStock": true,
    "rating": 4.7
  }
  ```
- Response:
  ```
  [
    {
        "id": "66a29166a38d6468b38d44e2",
        "name": "Laptop",
        "category": "electronics",
        "price": 899.99,
        "inStock": true,
        "rating": 4.7,
        "createdAt": "2024-07-25T17:54:46.157+00:00"
    }
  ]
  ```

# Contact
  If you need any help, please feel free to mail me at vasaniyaakshi8@gmail.com.
