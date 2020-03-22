package com.example.betprobability;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.betprobability.com.betprobability.model.Match;

import java.io.Serializable;
import java.util.List;


public class MatchAdminActivity extends BaseActivity implements Serializable {

    public static final String TAG = "MatchAdminActivity";
    private MatchAdapter mMatchAdapter;
    private RecyclerView mRecyclerViewMatch;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        mRecyclerViewMatch = findViewById(R.id.recycler_view_match);

        mMatchAdapter = new MatchAdapter(new MatchAdapter.SelectedListener() {
            @Override
            public void matchSelected(Match stats) {
                onMatchSelected(stats);
            }
        });

        mRecyclerViewMatch.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewMatch.setLayoutManager(mLayoutManager);
        mRecyclerViewMatch.setAdapter(mMatchAdapter);

        searchUpcomingMatchs();

    }
    private void onMatchSelected(Match stats) {
        Intent intent = new Intent(this, AdminMatchActivity.class);
        intent.putExtra("Match", stats);

        startActivity(intent);
    }

    private void searchUpcomingMatchs() {

//      new CitiesLoadingTask().execute();


/*        Intent intent = new Intent(this, SearchActivity.class);
        query = intent.getStringExtra("query");
        startActivity(intent);*/

        AndroidNetworking.get(AppConstants.BASE_URL+"/match/loadupcomingmatch")
                .build()
                .getAsObjectList(Match.class, new ParsedRequestListener<List<Match>>() {
                    @Override
                    public void onResponse(List<Match> matchs) {
                        mMatchAdapter.addAll(matchs);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Echec lecture des matchs", anError.getCause());
                    }
                });

    }

}
