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
	private int status;
	OkHttpClient client = new OkHttpClient();
		
	public Endpoint() {
		super();
	}
	
	public JSONObject getO() {
		
		return o;
	}
	//method for a request of endpoint with a specific url with OKHTTP
	public void req(String url) throws IOException{
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();

		String str = response.body().string();
		this.status = response.code(); // save a status code in a status atribute 
		this.o = new JSONObject(str);
		
	}
	
	//return status value
	public int status() throws IOException{
		return status;
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
