# Customer API Client

## Description
This is a console-based Java application to interact with the Customer API. The application allows you to perform CRUD operations and search for customers using a RESTful API.

## Features
- **Create a Customer**: Add a new customer to the database.
- **Retrieve All Customers**: Fetch all customer records.
- **Retrieve Customer by ID**: Fetch a single customer by their unique ID.
- **Search Customers**: Search for customers by name or phone number.
- **Update a Customer**: Update customer details.
- **Delete a Customer**: Remove a customer from the database.

## Prerequisites
- Java 17+
- Maven 3.8+
- A running instance of the Customer API (base URL: `http://localhost:8080/`).

## Installation
1. Clone the repository:
```bash
git clone https://github.com/your-username/customer-api-client.git
cd customer-api-client
```
2. Build the project:
```bash
mvn clean package
```

## Configuration
Update the `baseUrl` in the `Main` class to point to the correct Customer API URL:
```
String baseUrl = "http://localhost:8080/api";
```

## Running the Application
```bash
mvn exec:java -Dexec.mainClass="com.github.viachaslaubarkou.customerapiclient.Main"
```

## Author
Viachaslau Barkou

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
