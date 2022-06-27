package com.example.springtestingdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = Restapi.class)
class SpringTestingDemoApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private MyService servcie;
	
	@Test
	public void testGreetings() throws Exception {
		BDDMockito.given(servcie.welcome("Raj")).willReturn("Welcome Raj");
		mvc.perform(get("/api/Raj")).andExpect(content().string("WELCOME RAJ"));
	}

}
