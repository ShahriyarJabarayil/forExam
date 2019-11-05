package com.test.forexam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL="http://20.20.20.24/myquiz/accounts/";

    public static Retrofit retrofit=null;

    public static Retrofit getApiClient()
    {
        if (retrofit==null)
        {
            Gson gson=new GsonBuilder().serializeNulls().create();
             retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }


}
