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
        TypedArray agrowisataImageResources =
                getResources().obtainTypedArray(R.array.agrowisata_images);
        // Get the resources from the XML file.
        String[] agrowisataList = getResources()
                .getStringArray(R.array.wisata_titles);

        mWisataData.clear();

        for(int i=0;i<agrowisataList.length;i++){
            mWisataData.add(new Wisata(agrowisataList[i],
                    agrowisataImageResources.getResourceId(i,0)));
        }

        agrowisataImageResources.recycle();
        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }

}