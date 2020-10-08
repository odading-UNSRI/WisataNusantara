package com.example.wisatanusantara;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class agrowisata extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Wisata> mWisataData;
    private WisataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_wisata);


        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWisataData = new ArrayList<>();

        mAdapter = new WisataAdapter(this, mWisataData);
        mRecyclerView.setAdapter(mAdapter);

        int gridColumnCount =
                getResources().getInteger(R.integer.grid_column_count);
        mRecyclerView.setLayoutManager(new
                GridLayoutManager(this, gridColumnCount));

        initializeData();
    }

    private void initializeData() {
        TypedArray sportsImageResources =
                getResources().obtainTypedArray(R.array.sports_images);
        // Get the resources from the XML file.
        String[] sportsList = getResources()
                .getStringArray(R.array.wisata_titles);
        String[] sportsInfo = getResources()
                .getStringArray(R.array.wisata_info);

        // Clear the existing data (to avoid duplication).
        mWisataData.clear();

        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for(int i=0;i<sportsList.length;i++){
            mWisataData.add(new Wisata(sportsList[i],sportsInfo[i],
                    sportsImageResources.getResourceId(i,0)));
        }

        sportsImageResources.recycle();
        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }

}