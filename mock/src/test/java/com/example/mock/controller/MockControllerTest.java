package com.example.mock.controller;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MockController.class)
public class MockControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    RestTemplate template;
    @Test
    void searchTest() throws Exception{
        String query="hi";
        String result="helloHari";
        String externalUrl = "https://api.example.com/search?query=" + query;
        Mockito.when(template.getForEntity(externalUrl,String.class)).thenReturn(new ResponseEntity<>(result, HttpStatus.OK));
        mockMvc.perform(get("/api/search").param("query", query))
                .andExpect(status().isOk())
                .andExpect(content().string(result));}
}
