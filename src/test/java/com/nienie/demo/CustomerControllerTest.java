package com.nienie.demo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class) // this is allowing my test to use the Mockito version of JUnit
public class CustomerControllerTest {

    private MockMvc mockMvc; // this is me creating an instance on mockmvc so that i can later on create an implementation of the mockmvcbuilder interface

    @InjectMocks //this is me saying that i want to inject mocks on my Customer controller class
    private CustomerController controller;

    @Mock //this is me saying that i want to create mocks of my Customer service methods
    private CustomerService service;

    @Before //this is me setting my mockmvc to the Mockmvc Builder so that i can access the methods it has
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllCustomers() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/customers")).andExpect(MockMvcResultMatchers.status().isOk()); //This line of code is telling my test to create a mock on my getAllCustomers method to see if it work when i use it

        Mockito.verify(service).getAllCustomers(); // this line of code is checking that sevice actually uses the method getAllCUstomers

    }

    @Test
    public void getCustomer() throws Exception{

        List<Customer> customerList = Arrays.asList(
                new Customer("Nie", 21, "Pimp St", "F", "July 10",  90),
                new Customer("Shamis", 23, "New St", "M", "November 16", ( 10000)
        );

        Mockito.when(service.getCustomer((long) 1)).thenReturn(customerList.get(0));

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/{id}", 1)).
                andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(service).getCustomer((long) 1);



    }

}
