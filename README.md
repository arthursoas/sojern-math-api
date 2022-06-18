# 🔢 Math API
This project is part of Sojern Software Engineer assignment.

This API can do the following operations

- `/min` given list of numbers and a quantifier (how many) provides min number(s)
- `/max` given list of numbers and a quantifier (how many) provides max number(s)
- `/avg` given list of numbers calculates their average
- `/median` given list of numbers calculates their median
- `/percentile` given list of numbers and quantifier 'q', compute the qth percentile of the list elements using the nearest-rank method

## Available Scripts

`./mvnw spring-boot:run` - Starts the API locally and executes it on address http://localhost:8080

## Technologies used
- `Java` as programing language
- `spring-boot` for HTTP server
- `JUnit` for unit tests

## What this API do

This API has 5 endpoints, as described below:

#### Get min numbers
```http
POST /api/operation/min
{
  "numbers": [1, 1.5, 2],
  "quantifier": 1
}
```

#### Get max numbers
```http
POST /api/operation/max
{
  "numbers": [1, 1.5, 2],
  "quantifier": 1
}
```

#### Get numbers average
```http
POST /api/operation/avg
{
  "numbers": [1, 1.5, 2]
}
```

#### Get numbers median
```http
POST /api/operation/avg
{
  "numbers": [1, 1.5, 2]
}
```

#### Get numbers percentile
```http
POST /api/operation/avg
{
  "numbers": [1, 1.5, 2],
  "quantifier": 30
}
```

## What this API does not do
This API does not sync your data with any server, neither share your data with any third party.
