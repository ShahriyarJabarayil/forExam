package com.test.forexam.Interfaces;

import com.test.forexam.Model.Accounts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiJson {


    @FormUrlEncoded
    @POST("postaccount.php/")
    Call<Accounts> createUser(@Field("name") String name,
                              @Field("email") String email,
                              @Field("password") String password,
                              @Field("status") String status);


    @GET("getaccounts.php/")
    Call<List<Accounts>> getuser(@Query("name") String name,
                                @Query("password") String password);


    @GET("getaccounts.php/")
    Call<List<Accounts>> getUsers();


    @GET("getaccounts.php/")
    Call<Accounts> getuser0(@Query("name") String name,
                                 @Query("password") String password);
}
