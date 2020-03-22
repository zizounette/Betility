package com.example.betprobability;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChampionnatAdapter extends RecyclerView.Adapter<ChampionnatAdapter.viewHolder>{

    public interface selectedListener {
            void championnatSelected();
    }

    private selectedListener mListener;

    public static class viewHolder extends RecyclerView.ViewHolder {

        public ImageView mButtonChampionnat;

        public viewHolder(@NonNull View itemView, final selectedListener listener) {
            super(itemView);

            this.mButtonChampionnat = itemView.findViewById(R.id.imageViewLigue1);
            mButtonChampionnat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   listener.championnatSelected();
                }
            });
        }
    }
    public ChampionnatAdapter(selectedListener listener) {
        this.mListener = listener;
    }

    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_championnat, parent, false);

        return new viewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

}
