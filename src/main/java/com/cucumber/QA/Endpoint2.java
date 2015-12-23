package com.cucumber.QA;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Endpoint2 {
	//JSONArray with add the arrays of JSON's Objects 
	private JSONArray o; 
	OkHttpClient client = new OkHttpClient();
			
	public Endpoint2() {
		super();
	}
	
	public JSONArray getO() {
		return o;
	}
	
	// method for a request of endpoint with a specific url
	public void req(String url) throws IOException{
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();

		String str = response.body().string();
	
		o = new JSONArray(str);
	}
	
	
	//status value of the endpoint is in int
	public int status() throws IOException{
		Request request = new Request.Builder().url("http://jsonplaceholder.typicode.com/posts/1/comments").build();

		Response response = client.newCall(request).execute();

		return response.code();
	}

}
