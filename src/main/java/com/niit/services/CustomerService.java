package com.niit.services;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerService {
void saveCustomer(Customer customer);
List<Customer> getCustomers();

void update(Customer customer);
Customer getcustomerbyname(String name);
}
