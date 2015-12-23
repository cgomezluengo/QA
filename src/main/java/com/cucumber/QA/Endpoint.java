package com.cucumber.QA;
import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;



public class Endpoint {
	//JSON Object for take a json 
	private JSONObject o;
	OkHttpClient client = new OkHttpClient();
		
	public Endpoint() {
		super();
	}
	
	public JSONObject getO() {
		
		return o;
	}
	//method for a request of endpoint with a specific url
	public void req(String url) throws IOException{
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();

		String str = response.body().string();
	
		this.o = new JSONObject(str);
	}
	
	//status value of the endpoint is in int
	public int status() throws IOException{
		Request request = new Request.Builder().url("http://jsonplaceholder.typicode.com/posts/1").build();

		Response response = client.newCall(request).execute();

		return response.code();
	}

	public int userId() {
		return getO().getInt("userId");
	}
	public int id() {
		return getO().getInt("id");
	}
	public String title() {
		return getO().getString("title");
	}
	public String body() {
		return getO().getString("body");
	}
}
