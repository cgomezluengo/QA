package com.cucumber.QA;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs2 {
	Endpoint2 e = new Endpoint2();

	@Given("^a get request to second endpoint \"([^\"]*)\"$")
	public void a_get_request_to_second_endpoint(String arg1) throws Throwable {
		try {
			e.req(arg1); // create a request with the url in arg1
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^Value a fields of the second endpoint$")
	public void value_a_fields_of_the_second_endpoint() throws Throwable {

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

	@Then("^has more than (\\d+) comment$")
	public void has_more_than_comment(int arg1) throws Throwable {
		Assert.assertTrue(e.getO().length() > arg1); //true if there more than arg1 value comment(s) 
	}

	@Then("^the \"([^\"]*)\" fields has in all comments$")
	public void the_fields_has_in_all_comments(String arg1) throws Throwable {
		for (int i = 0; i < e.getO().length(); i++) { // i take all comments 
			Assert.assertTrue(e.getO().getJSONObject(i).has(arg1)); // and true if within have a field arg1 (email in this case)
		}
		
	}
}
