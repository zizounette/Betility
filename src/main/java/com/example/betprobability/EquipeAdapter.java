package com.example.betprobability;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.widget.ANImageView;
import com.example.betprobability.com.betprobability.model.Equipe;

import java.util.ArrayList;
import java.util.List;

public class EquipeAdapter extends RecyclerView.Adapter<EquipeAdapter.viewHolder> {

    private List<Equipe> mStats;
    private SelectedListener mListener;

    public static class viewHolder extends RecyclerView.ViewHolder {

        public Equipe mStat;
        public ANImageView mImageViewEquipe1;

        public viewHolder(@NonNull View itemView, final SelectedListener listener) {
            super(itemView);

            this.mImageViewEquipe1 = itemView.findViewById(R.id.image_equipe1);
            mImageViewEquipe1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.matchSelected(mStat);
                }
            });
        }
    }

    public interface SelectedListener {
        void matchSelected(Equipe stats);
    }

    public EquipeAdapter(SelectedListener listener) {
        this.mStats = new ArrayList<>();
        this.mListener = listener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);

        return new viewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int i) {
        Equipe stats = mStats.get(i);
        holder.mImageViewEquipe1.setImageUrl(AppConstants.BASE_URL + "/images/" + stats.getId());
        holder.mStat = stats;
    }

    @Override
    public int getItemCount() {
        return mStats.size();
    }

    public void addAll (List<Equipe> stats) {
        this.mStats.addAll(stats);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mStats.clear();
        notifyItemRangeRemoved(0, mStats.size());
    }
}
