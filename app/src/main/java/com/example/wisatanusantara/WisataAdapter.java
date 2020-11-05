package com.example.wisatanusantara;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wisatanusantara.model.WisataItem;

import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {

    private ArrayList<WisataItem> mWisataData;
    private Context mContext;

    public WisataAdapter(ArrayList<WisataItem> mWisataData, Context mContext) {
        this.mWisataData = mWisataData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_wisata,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTitleText.setText(mWisataData.get(position).getNama());
        Glide.with(mContext).load(mWisataData.get(position).getGambarUrl()).error(R.mipmap.ic_wisnu)
            .override(512,512)
            .into(holder.mWisataImage);
    }

    @Override
    public int getItemCount() {
        return mWisataData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleText;
        private ImageView mWisataImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mWisataImage = itemView.findViewById(R.id.wisataImage);
        }
    }
}

