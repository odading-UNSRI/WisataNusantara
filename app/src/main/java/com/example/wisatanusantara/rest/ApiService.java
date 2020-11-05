package com.example.wisatanusantara.rest;

import com.example.wisatanusantara.model.RoodPariwisataModel;
import com.example.wisatanusantara.model.WisataItem;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("purwakarta/wisata") //endpoint
    Call<RoodPariwisataModel> getData();
}