package com.example.wisatanusantara;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisatanusantara.adapter.WisataAdapter;
import com.example.wisatanusantara.alarm.AlarmActivity;
import com.example.wisatanusantara.model.RoodPariwisataModel;
import com.example.wisatanusantara.model.WisataItem;
import com.example.wisatanusantara.rest.ApiConfig;
import com.example.wisatanusantara.rest.ApiService;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class main extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<WisataItem> wisataItems;
    private WisataAdapter wisataAdapter;
    private Text mAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        wisataItems = new ArrayList<>();
        getData();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        mAlarm= findViewById(R.id.action_alarm);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_alarm:
                Intent intent = new Intent(main.this, AlarmActivity.class);
                String mOrderMessage = null;
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }
}