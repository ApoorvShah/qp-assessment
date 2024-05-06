# Grocery Application

## Overview

The Grocery Application is a RESTful API designed to manage grocery items. It provides endpoints for administrators to add, view, update, and delete products, as well as manage inventory levels.

## API Endpoints

### Add Product

Adds a new product to the system.

- **Method**: POST
- **URL**: `/api/v1/admin/products`
- **Request Body**:
  ```json
  {
    "name": "Samsung phone",
    "price": 50000,
    "quantity": 50
  }
  ```

### Get All Products

Retrieves a list of all available products.

- **Method**: GET
- **URL**: `/api/v1/admin/products`

### Get Single Product

Retrieves information about a specific product by ID.

- **Method**: GET
- **URL**: `/api/v1/admin/products/{productId}`
- **Example**: `/api/v1/admin/products/5`

### Update Single Product

Updates details (name, price, quantity) of a specific product.

- **Method**: PUT
- **URL**: `/api/v1/admin/products/{productId}`
- **Request Body**:
  ```json
  {
    "name": "Apple phone",
    "price": 101000,
    "quantity": 2
  }
  ```
- **Example**: `/api/v1/admin/products/2`

### Delete Single Product

Removes a product from the system by ID.

- **Method**: DELETE
- **URL**: `/api/v1/admin/products/{productId}`
- **Example**: `/api/v1/admin/products/4`

### Manage Inventory

Updates the inventory level of a specific product.

- **Method**: PUT
- **URL**: `/api/v1/admin/products/{productId}/inventory`
- **Request Body**: The new quantity to add (integer).
  ```
  10
  ```
- **Example**: `/api/v1/admin/products/1/inventory`

## Usage

You can make HTTP requests to the provided endpoints using tools like curl or Postman. Here are some example HTTP requests:

### Add Product

```http
POST /api/v1/admin/products HTTP/1.1
Host: localhost:9999
Content-Type: application/json
Content-Length: 75

{
"name": "Samsung phone",
"price": 50000,
"quantity": 50
}
```

### Get All Products

```http
GET /api/v1/admin/products HTTP/1.1
Host: localhost:9999
```

### Get Single Product

```http
GET /api/v1/admin/products/5 HTTP/1.1
Host: localhost:9999
```

### Update Single Product

```http
PUT /api/v1/admin/products/2 HTTP/1.1
Host: localhost:9999
Content-Type: application/json
Content-Length: 68

{
"name": "Apple phone",
"price": 101000,
"quantity": 2
}
```

### Delete Single Product

```http
DELETE /api/v1/admin/products/4 HTTP/1.1
Host: localhost:9999
```

### Manage Inventory

```http
PUT /api/v1/admin/products/1/inventory HTTP/1.1
Host: localhost:9999
Content-Type: application/json
Content-Length: 2

10

```
