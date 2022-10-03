package com.example.apiappp;

import com.example.apiappp.model.URLResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "X-RapidAPI-Key:7a8b10da4cmsh4a8087897ee6280p170986jsn4cfc51f19511",
            "X-RapidAPI-Host: url-shortener-service.p.rapidapi.com"
    })
    @FormUrlEncoded
    @POST("/shorten")
    Call<URLResponse> getShortURL(@Field("url") String longURL );




}
