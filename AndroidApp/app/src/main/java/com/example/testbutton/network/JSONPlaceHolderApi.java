package com.example.testbutton.network;

import com.example.testbutton.model.UserView;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);

    @POST("/api/account/login")
    public Call<Tokens> login(@Body Login m);

    @GET("/api/profile")
    Call<UserView> profile();
    ///@POST("/api/auth/refresh")
    ///public Call<Tokens> refresh(@Body Refresh m);

}
