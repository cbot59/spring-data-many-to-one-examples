# Spring Data @ManyToOne Example

Example code to demo how to persist parent entity through child entity

## Prerequisites

* Java 17
* Maven

## Running the app

Use [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#using) to run 
the app.

```bash
mvn spring-boot:run
```

## Usage

### Get Products

#### Request

```bash
curl -X GET --location "http://localhost:8080/api/products" \
    -H "Accept: application/json"
```

#### Sample Response

```json
{
  "_embedded": {
    "products": [
      {
        "name": "Handphone",
        "quantity": 2,
        "_links": {
          "self": {
            "href": "http://localhost:8080/api/products/1"
          },
          "product": {
            "href": "http://localhost:8080/api/products/1"
          },
          "brand": {
            "href": "http://localhost:8080/api/products/1/brand"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/products"
    },
    "profile": {
      "href": "http://localhost:8080/api/profile/products"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 1,
    "totalPages": 1,
    "number": 0
  }
}
```

### Save Products along with its Brand

#### Sample Request

```bash
curl -X POST --location "http://localhost:8080/products" \
    -H "Accept: application/json" \
    -H "Content-Type: application/json" \
    -d "{
          \"name\": \"Handphone\",
          \"quantity\": 2,
          \"brand\": {
            \"name\": \"Samsung\",
            \"createdDate\": \"2020-01-04\"
          }
        }"
```

#### Sample Response

```json
{
  "id": 1,
  "name": "Handphone",
  "quantity": 2,
  "brand": {
    "id": 1,
    "name": "Samsung",
    "createdDate": "2020-01-04"
  }
}
```

### Get Brands

#### Request

```bash
curl -X GET --location "http://localhost:8080/api/brands" \
    -H "Accept: application/json"
```

#### Sample Response

```json
{
  "_embedded": {
    "brands": [
      {
        "name": "Samsung",
        "createdDate": "2020-01-04",
        "_links": {
          "self": {
            "href": "http://localhost:8080/api/brands/1"
          },
          "brand": {
            "href": "http://localhost:8080/api/brands/1"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/brands"
    },
    "profile": {
      "href": "http://localhost:8080/api/profile/brands"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 1,
    "totalPages": 1,
    "number": 0
  }
}
```

## DDL

### Product (parent)

| ID | NAME | QUANTITY | BRAND_ID |
|----|------|----------|----------|
|    |      |          |          |

### Brand (child)

| ID | CREATED_DATE | NAME |
|----|--------------|------|
|    |              |      |

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
