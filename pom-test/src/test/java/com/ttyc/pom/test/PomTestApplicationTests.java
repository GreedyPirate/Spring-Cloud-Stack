package com.ttyc.pom.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PomTestApplicationTests {

	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		String params = "{\"id\": 101,\"username\": \"jason\",\"password\": \"1234\"}";
		mockMvc.perform(post("/user/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(params))
				.andExpect(status().isOk());
	}

}
