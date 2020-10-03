package com.example.testbutton.network;

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
    ///@POST("/api/auth/refresh")
    ///public Call<Tokens> refresh(@Body Refresh m);

}
