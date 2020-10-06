package com.example.wisatanusantara;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {
    // Member variables.
    private ArrayList<Wisata> mWisataData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param wisataData ArrayList containing the sports data.
     * @param context    Context of the application.
     */
    WisataAdapter(Context context, ArrayList<Wisata> wisataData) {
        this.mWisataData = wisataData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent   The ViewGroup into which the new View will be added
     *                 after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public WisataAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item_wisata, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder   The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(WisataAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Wisata currentWisata = mWisataData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentWisata);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mWisataData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mWisataImage;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            //Initialize the views
            mTitleText = itemView.findViewById(R.id.title);
            mWisataImage = itemView.findViewById(R.id.wisataImage);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Wisata currentWisata) {
            // Populate the textviews with data.
            mTitleText.setText(currentWisata.getTitle());
            Glide.with(mContext).load(currentWisata.getImageResource()).into(mWisataImage);
        }

        @Override
        public void onClick(View view) {
            Wisata currentSport = mWisataData.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext, DetailWisata.class);
            detailIntent.putExtra("title", currentSport.getTitle());
            detailIntent.putExtra("image_resource",
                    currentSport.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }
}
