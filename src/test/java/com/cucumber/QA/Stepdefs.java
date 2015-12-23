package com.cucumber.QA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	Endpoint e = new Endpoint();
	
	@Given("^a get request to \"([^\"]*)\"$")
	public void a_get_request_to(String arg1) throws Throwable {
		try {
			e.req(arg1); // create a request with the url in arg1
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^Value a fields of the first endpoint$")
	public void value_a_fields_of_the_first_endpoint() throws Throwable {
	   
	}

	@Then("^the status code should be (\\d+)$")
	public void the_status_code_should_be(int arg1) throws Throwable {
		try {
			
			assertEquals(arg1, e.status());  //verify the status code in 200
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^fields userId should be (\\d+)$")
	public void fields_userId_should_be(int arg1) throws Throwable {
		try {
			assertEquals(Long.valueOf(arg1), Long.valueOf(e.userId())); // true if the userId is 1 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^id should be (\\d+)$")
	public void id_should_be(int arg1) throws Throwable {
		try {
			assertEquals(arg1, e.id()); //true if id is 1
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^fields title  dont be null$")
	public void fields_title_dont_be_null() throws Throwable {
		assertNotNull(e.title()); // true if the title is null
	}

	@Then("^body don't be null$")
	public void body_don_t_be_null() throws Throwable {
		assertNotNull(e.body()); // if body is null the assert is true
	}
}
