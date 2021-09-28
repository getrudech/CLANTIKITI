package com.example.clantikiti.network;


import com.example.clantikiti.models.Events;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("/events")
    Call<List<Events>> getEvents();
}
