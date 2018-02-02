package com.nienie.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

//    private List<Customer> customers = new ArrayList<>(Arrays.asList(
//            new Customer("Mike", 23),
//            new Customer("Jones", 21)
//    ));

    @Autowired
    CustomerRespository customerRespository;

    public List<Customer> getAllCustomers() {
        List<Customer>customers = new ArrayList<>();
        customerRespository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomer(Long id){
       return customerRespository.findOne(id);
        //return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
    }

    public void addCustomer(Customer customer){
        customerRespository.save(customer);
    }

    public void updateCustomer(Long id, Customer customer){
        customerRespository.save(customer);
    }


    public void deleteCustomer(Long id){
        customerRespository.delete(id);
        //topics.removeIf(t-> t.getId().equals(id));
    }
}
