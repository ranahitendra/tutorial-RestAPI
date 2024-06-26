# tutorial-RestAPI
Tutorial from Grovetech

## Requirements
- Java 8+
- MySQL

## Setup

### MySQL Configuration
1. Create a database named `products`.
2. Database Username  : root
3. Database Password :  
4. Update the database configuration in `src/main/resources/application.properties`.

### Run the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run`.

### API Endpoints

#### Add Product
- Method: POST
- URL: `/v1/products`
- Request Body:
```json
{
    "name": "Red Shirt",
    "description": "Red hugo boss shirt",
    "brand": "Hugo Boss",
    "tags": ["red", "shirt", "slim fit"],
    "category": "apparel"
}
