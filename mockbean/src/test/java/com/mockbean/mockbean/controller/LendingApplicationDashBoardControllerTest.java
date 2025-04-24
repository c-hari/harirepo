package com.mockbean.mockbean.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.mockbean.mockbean.service.LendingApplicationServiceImpl;

@WebMvcTest(LendingApplicationDashBoardController.class)
public class LendingApplicationDashBoardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private LendingApplicationServiceImpl impl;
	
	@Test
	void testExport() {
		 String res="hari";
		Mockito.when(impl.getData(res)).thenReturn(res);
		//mockMvc.perform(get("/"))res.
	}

}
