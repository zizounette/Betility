package com.example.betprobability;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.widget.ANImageView;
import com.example.betprobability.com.betprobability.model.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.viewHolder> {

    private List<Match> mStats;
    private SelectedListener mListener;

    public static class viewHolder extends RecyclerView.ViewHolder {

        public Match mStat;
        public ANImageView mImageViewEquipe1;
        public ANImageView mImageViewEquipe2;
        public TextView mTeamOne;
        public TextView mTeamTwo;
        public LinearLayout mLinearTeamLayout;

        public viewHolder(@NonNull View itemView, final SelectedListener listener) {
            super(itemView);

            this.mLinearTeamLayout = itemView.findViewById(R.id.linearTeamLayout);
            this.mImageViewEquipe1 = itemView.findViewById(R.id.image_equipe1);
            this.mImageViewEquipe2 = itemView.findViewById(R.id.image_equipe2);
            this.mTeamOne = itemView.findViewById(R.id.textViewTeamOne);
            this.mTeamTwo = itemView.findViewById(R.id.textViewTeamTwo);
            mLinearTeamLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.matchSelected(mStat);
                }
            });
        }
    }

    public interface SelectedListener {
        void matchSelected(Match stats);
    }

    public MatchAdapter(SelectedListener listener) {
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
        Match stats = mStats.get(i);
        holder.mImageViewEquipe1.setImageUrl(AppConstants.BASE_URL + "/images/" + stats.getEquipe1().getId());
        holder.mImageViewEquipe2.setImageUrl(AppConstants.BASE_URL + "/images/" + stats.getEquipe2().getId());
        holder.mTeamOne.setText(stats.getEquipe1().getEquipe());
        holder.mTeamTwo.setText(stats.getEquipe2().getEquipe());
        holder.mStat = stats;
    }

    @Override
    public int getItemCount() {
        return mStats.size();
    }

    public void addAll (List<Match> stats) {
        this.mStats.addAll(stats);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mStats.clear();
        notifyItemRangeRemoved(0, mStats.size());
    }
}
