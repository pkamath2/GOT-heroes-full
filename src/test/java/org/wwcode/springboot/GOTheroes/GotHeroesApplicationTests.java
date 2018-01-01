package org.wwcode.springboot.GOTheroes;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GotHeroesApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testRest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/GOT/heroes"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].hero-name", Matchers.equalToIgnoringCase("Daenerys Targaryen")));
	}
}
