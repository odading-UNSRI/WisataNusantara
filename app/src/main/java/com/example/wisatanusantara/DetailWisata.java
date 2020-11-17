package com.example.wisatanusantara;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailWisata extends AppCompatActivity {
    private TextView mTitleText;
    private ImageView mWisataImage;
    private TextView mCategoryText;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_detail_wisata);
        initView();

        mTitleText.setText(getIntent().getStringExtra("nama"));
        mCategoryText.setText(getIntent().getStringExtra("kategori"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambarUrl")).error(R.mipmap.ic_wisnu)
                .override(512, 512)
                .into(mWisataImage);

    }

    private void initView() {
        mTitleText = findViewById(R.id.title);
        mWisataImage = findViewById(R.id.wisataImage);
        mCategoryText = findViewById(R.id.wisataCategory);
    }
}