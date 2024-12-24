package com.github.viachaslaubarkou.customerapiclient;

public class Main {
    public static void main(String[] args) {
        try {
            String baseUrl = "http://localhost:8080/api";
            CustomerClient client = new CustomerClient(baseUrl);

            Customer customer1 = client.createCustomer(new Customer(
                    null,
                    "Ivan",
                    "Da",
                    "Maria",
                    "new.email@example.com",
                    "1234567890"));
            System.out.println("Create customer 1: " + customer1);
            Customer customer2 = client.createCustomer(new Customer(
                    null,
                    "Ivan",
                    null,
                    "Ivanov",
                    "ivan.ivanov@example.com",
                    "+11111111111"
            ));
            System.out.println("Create customer 2: " + customer2);

            System.out.println("All Customers:");
            client.getAllCustomers().forEach(System.out::println);

            System.out.println("Searching for Customer by ID:");
            System.out.println("Found Customer: " + client.getCustomerById(customer2.getId()));

            System.out.println("Searching for Customers by First Name:");
            client.getCustomersByName("Ivan").forEach(System.out::println);

            System.out.println("Searching for Customers by Phone Number:");
            client.getCustomersByPhoneNumber("1111111").forEach(System.out::println);

            customer1.setPhoneNumber("9876543210");
            Customer updatedCustomer = client.updateCustomer(customer1);
            System.out.println("Updated Customer: " + updatedCustomer);

            client.deleteCustomer(customer1.getId());
            System.out.printf("Customer with id = %s deleted.", customer1.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
