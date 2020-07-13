package com.desafio.githubsearchjavadevelopers.api;

import com.desafio.githubsearchjavadevelopers.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/search/users?q=language:Java+location:Brasil")
    Call<ItemResponse> getItems();
}
