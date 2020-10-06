package com.example.wisatanusantara;

import android.content.Intent;
import android.support.design.card.MaterialCardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        cvAgrowisata = (CardView) findViewById(R.id.cvAgrowisata);
        cvAlam = (CardView) findViewById(R.id.cvAlam);
        cvBudaya = (CardView) findViewById(R.id.cvBudaya);
        cvEdukasi = (CardView) findViewById(R.id.cvEdukasi);
        cvKawasanWisataTerpadu = (CardView) findViewById(R.id.cvKawasanWisataTerpadu);
        cvKolamRenang = (CardView) findViewById(R.id.cvKolamRenang);
        cvLainLain = (CardView) findViewById(R.id.cvLainLain);
        cvMinatKhusus = (CardView) findViewById(R.id.cvMinatKhusus);
        cvReligi = (CardView) findViewById(R.id.cvReligi);
        cvTaman = (CardView) findViewById(R.id.cvTaman);
    }
}