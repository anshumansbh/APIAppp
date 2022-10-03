package com.example.apiappp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient {

    static Retrofit getClient() {

        OkHttpClient client = new OkHttpClient.Builder().build();


        @SuppressWarnings("UnnecessaryLocalVariable")
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://url-shortener-service.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }

}