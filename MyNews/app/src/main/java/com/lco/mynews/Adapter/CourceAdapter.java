package com.lco.mynews.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourceAdapter extends  RecyclerView.Adapter<CourceAdapter.CourceViewHolder>{
    @NonNull
    @Override
    public CourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CourceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CourceViewHolder extends RecyclerView.ViewHolder{

        public CourceViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
