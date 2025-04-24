package com.mockbean.mockbean.controller;

import com.mockbean.mockbean.entity.Customer;
import com.mockbean.mockbean.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerRestController.class)
class CustomerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void testFindById_ReturnsCustomer() throws Exception {
        // Given
        Customer customer = new Customer();
        customer.setCustId(1);
        customer.setCustName("hari");
        customer.setAge(23);
        customer.setAddress("ooty");

        // Mocking service
        Mockito.when(customerService.findById(1)).thenReturn(Optional.of(customer));

        // When & Then
        mockMvc.perform(get("/customer/findById/{custId}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.custId").value(1))
                .andExpect(jsonPath("$.custName").value("hari"))
                .andExpect(jsonPath("$.age").value(23))
                .andExpect(jsonPath("$.address").value("ooty"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        Mockito.when(customerService.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/customer/findById/{custId}", 99))
                .andExpect(status().isNotFound());
    }
}
