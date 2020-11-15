package com.example.wisatanusantara;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {

    private Button btnLihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                finishAffinity();
                startActivity(new Intent(getApplicationContext(), agrowisata.class));
            }
        });

    }

    private void initView() {
        btnLihat = findViewById(R.id.btn_mulai);
    }
}