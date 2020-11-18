package com.example.wisatanusantara;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisatanusantara.adapter.WisataAdapter;
import com.example.wisatanusantara.model.RoodPariwisataModel;
import com.example.wisatanusantara.model.WisataItem;
import com.example.wisatanusantara.rest.ApiConfig;
import com.example.wisatanusantara.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class main extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<WisataItem> wisataItems;
    private WisataAdapter wisataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        wisataItems = new ArrayList<>();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<RoodPariwisataModel>() {
            @Override
            public void onResponse(Call<RoodPariwisataModel> call, Response<RoodPariwisataModel> response) {
                if (response.isSuccessful()) {
                    wisataItems = response.body().getWisata();
                    wisataAdapter = new WisataAdapter(wisataItems, getApplicationContext());
                    recyclerView.setAdapter(wisataAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<RoodPariwisataModel> call, Throwable t) {
                Toast.makeText(main.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}