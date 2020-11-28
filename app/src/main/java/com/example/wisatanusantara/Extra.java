package com.example.wisatanusantara;

import android.content.Context;
import android.util.Log;

import androidx.room.TypeConverter;

import com.example.wisatanusantara.db.Wisata;
import com.example.wisatanusantara.model.WisataItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Extra {
    private static String TAG = com.example.wisatanusantara.Extra.class.getSimpleName();

    public static void wisataToDB(Context context, ArrayList<WisataItem> wisataItems){
        for (WisataItem wisataItem: wisataItems){
            if (main.db.getWisata().getAllWisata() == null){
                try {
                    Wisata wisata = new Wisata(
                            String.valueOf(wisataItem.getNama()),
                            String.valueOf(wisataItem.getGambarUrl()),
                            String.valueOf(wisataItem.getKategori()));

                    main.db.getWisata().insertWisata(wisata);
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}
