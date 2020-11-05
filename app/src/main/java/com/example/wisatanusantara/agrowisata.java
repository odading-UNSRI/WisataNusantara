package com.example.wisatanusantara;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisatanusantara.model.RoodPariwisataModel;
import com.example.wisatanusantara.model.WisataItem;
import com.example.wisatanusantara.rest.ApiConfig;
import com.example.wisatanusantara.rest.ApiService;


import java.lang.ref.SoftReference;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class agrowisata extends AppCompatActivity {
    private RecyclerView recyclerView;

    private ArrayList<WisataItem> wisataItems;
    private WisataAdapter wisataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_wisata);
        initView();
        wisataItems = new ArrayList<>();
        getData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData()
                .enqueue(new Callback<RoodPariwisataModel>() {
                    @Override
                    public void onResponse(@NonNull Call<RoodPariwisataModel> call, @NonNull Response<RoodPariwisataModel> response) {
                        if (response.isSuccessful()){
                                    wisataItems = response.body().getWisata();
                                    wisataAdapter = new WisataAdapter(wisataItems, getApplicationContext());
                                    wisataAdapter.notifyDataSetChanged();
                                    recyclerView.setAdapter(wisataAdapter);
                                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<RoodPariwisataModel> call, @NonNull Throwable t) {
                        Toast.makeText(agrowisata.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}