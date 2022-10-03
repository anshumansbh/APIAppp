package com.example.apiappp.model;

import com.google.gson.annotations.SerializedName;

public class URLResponse{

	@SerializedName("result_url")
	private String resultUrl;

	public void setResultUrl(String resultUrl){
		this.resultUrl = resultUrl;
	}

	public String getResultUrl(){
		return resultUrl;
	}
}