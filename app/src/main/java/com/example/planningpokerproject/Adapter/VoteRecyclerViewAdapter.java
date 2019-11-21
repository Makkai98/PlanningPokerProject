package com.example.planningpokerproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpokerproject.R;


public class VoteRecyclerViewAdapter extends RecyclerView.Adapter<com.example.planningpokerproject.Adapter.VoteRecyclerViewAdapter.ViewHolder>    {


    private String[] mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public VoteRecyclerViewAdapter(   Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }




    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.voterecyclerview_item, parent, false);

        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final  int position) {
        holder.myTextView.setText(mData[position]);

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.length;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView myTextView;
        public LinearLayout linearLayout;
         public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            myTextView = itemView.findViewById(R.id.info_text);
            linearLayout =itemView.findViewById(R.id.linear_layout);

        }
        @Override
        public void onClick(View view)
        {
            // get the position on recyclerview.
            int pos = getLayoutPosition();
            Log.d("tag", getItem(pos));

        }




    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData[id];
    }

    // allows clicks events to be caught


}




