package com.example.wisatanusantara.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class RoodPariwisataModel{

    @SerializedName("wisata")
    private ArrayList<WisataItem> wisata;

    public void setWisata(ArrayList<WisataItem> wisata){
        this.wisata = wisata;
    }

    public ArrayList<WisataItem> getWisata(){
        return wisata;
    }
}