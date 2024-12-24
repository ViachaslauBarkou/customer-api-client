package com.github.viachaslaubarkou.customerapiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.util.Arrays;
import java.util.List;

public class CustomerClient {
    private final String baseUrl;
    private final ObjectMapper objectMapper;
    private final CloseableHttpClient httpClient;

    public CustomerClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.objectMapper = new ObjectMapper();
        this.httpClient = HttpClients.createDefault();
    }

    public List<Customer> getAllCustomers() throws Exception {
        HttpGet request = new HttpGet(baseUrl + "/customers/getAll");
        try (var response = httpClient.execute(request)) {
            String json = new String(response.getEntity().getContent().readAllBytes());
            return Arrays.asList(objectMapper.readValue(json, Customer[].class));
        }
    }

    public Customer getCustomerById(String id) throws Exception {
        HttpGet request = new HttpGet(baseUrl + "/customers/getById?id=" + id);
        try (var response = httpClient.execute(request)) {
            String json = new String(response.getEntity().getContent().readAllBytes());
            return objectMapper.readValue(json, Customer.class);
        }
    }

    public List<Customer> getCustomersByName(String name) throws Exception {
        HttpGet request = new HttpGet(baseUrl + "/customers/getByName?name=" + name);
        try (var response = httpClient.execute(request)) {
            String json = new String(response.getEntity().getContent().readAllBytes());
            return Arrays.asList(objectMapper.readValue(json, Customer[].class));
        }
    }

    public List<Customer> getCustomersByPhoneNumber(String phoneNumber) throws Exception {
        HttpGet request = new HttpGet(baseUrl + "/customers/getByPhoneNumber?phoneNumber=" + phoneNumber);
        try (var response = httpClient.execute(request)) {
            String json = new String(response.getEntity().getContent().readAllBytes());
            return Arrays.asList(objectMapper.readValue(json, Customer[].class));
        }
    }

    public Customer createCustomer(Customer customer) throws Exception {
        HttpPost request = new HttpPost(baseUrl + "/customers/create");
        String json = objectMapper.writeValueAsString(customer);
        request.setEntity(new StringEntity(json));
        request.setHeader("Content-Type", "application/json");
        try (var response = httpClient.execute(request)) {
            String responseJson = new String(response.getEntity().getContent().readAllBytes());
            return objectMapper.readValue(responseJson, Customer.class);
        }
    }

    public Customer updateCustomer(Customer customer) throws Exception {
        HttpPost request = new HttpPost(baseUrl + "/customers/update");
        String json = objectMapper.writeValueAsString(customer);
        request.setEntity(new StringEntity(json));
        request.setHeader("Content-Type", "application/json");
        try (var response = httpClient.execute(request)) {
            String responseJson = new String(response.getEntity().getContent().readAllBytes());
            return objectMapper.readValue(responseJson, Customer.class);
        }
    }

    public void deleteCustomer(String id) throws Exception {
        HttpDelete request = new HttpDelete(baseUrl + "/customers/delete?id=" + id);
        httpClient.execute(request).close();
    }
}
