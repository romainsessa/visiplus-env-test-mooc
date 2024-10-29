package fr.visiplus.book.controllers;

import static org.hamcrest.Matchers.hasSize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookControllerSteps extends SpringIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	private ResultActions resultActions;
	
	@Given("the client calls book endpoint")
	public void the_client_calls_book_endpoint() throws Exception {
		resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/book"));
	}
	
	@When("the response is provided")
	public void the_response_is_provided() throws Exception {
		resultActions.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Then("the client receives a list with {int} elements")
	public void the_client_receives_a_list_with_elements(int expectedElements) throws Exception {
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(expectedElements)));
	}
	
}
