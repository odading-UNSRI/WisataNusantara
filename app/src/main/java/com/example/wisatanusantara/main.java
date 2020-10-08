package com.example.wisatanusantara;

import android.content.Intent;
import android.support.design.card.MaterialCardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class main extends AppCompatActivity {

    private ImageView ivAgrowisata;
    private ImageView ivAlam;
    private ImageView ivBudaya;
    private ImageView ivEdukasi;
    private ImageView ivKawasanWisataTerpadu;
    private ImageView ivKolamRenang;
    private ImageView ivLainLain;
    private ImageView ivMinatKhusus;
    private ImageView ivReligi;
    private ImageView ivTaman;
    private CardView cvAgrowisata;
    private CardView cvAlam;
    private CardView cvBudaya;
    private CardView cvEdukasi;
    private CardView cvKawasanWisataTerpadu;
    private CardView cvKolamRenang;
    private CardView cvLainLain;
    private CardView cvMinatKhusus;
    private CardView cvReligi;
    private CardView cvTaman;

    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.text_view);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();
        initView();

        cvAgrowisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Wisata.class));
            }
        });
    }

    public void progressAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, textView, 0f, 100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }

    private void initView() {
        cvAgrowisata = (CardView) findViewById(R.id.cv_Agrowisata);
        cvAlam = (CardView) findViewById(R.id.cv_Alam);
        cvBudaya = (CardView) findViewById(R.id.cv_Budaya);
        cvEdukasi = (CardView) findViewById(R.id.cv_Edukasi);
        cvKawasanWisataTerpadu = (CardView) findViewById(R.id.cv_KawasanWisataTerpadu);
        cvKolamRenang = (CardView) findViewById(R.id.cv_KolamRenang);
        cvLainLain = (CardView) findViewById(R.id.cv_LainLain);
        cvMinatKhusus = (CardView) findViewById(R.id.cv_MinatKhusus);
        cvReligi = (CardView) findViewById(R.id.cv_Religi);
        cvTaman = (CardView) findViewById(R.id.cv_Taman);
    }
}