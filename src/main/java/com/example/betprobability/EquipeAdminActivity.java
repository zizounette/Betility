package com.example.betprobability;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.betprobability.com.betprobability.model.Equipe;

import java.io.Serializable;
import java.util.List;


public class EquipeAdminActivity extends BaseActivity implements Serializable {

    public static final String TAG = "EquipeAdminActivity";
    private EquipeAdapter mMatchAdapter;
    private RecyclerView mRecyclerViewMatch;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        mRecyclerViewMatch = findViewById(R.id.recycler_view_match);

        mMatchAdapter = new EquipeAdapter(new EquipeAdapter.SelectedListener() {
            @Override
            public void matchSelected(Equipe stats) {
                onMatchSelected(stats);
            }
        });

        mRecyclerViewMatch.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewMatch.setLayoutManager(mLayoutManager);
        mRecyclerViewMatch.setAdapter(mMatchAdapter);

        searchUpcomingMatchs();

    }
    private void onMatchSelected(Equipe stats) {
        Intent intent = new Intent(this, AdminEquipeActivity.class);
        intent.putExtra("Equipe", stats);

        startActivity(intent);
    }

    private void searchUpcomingMatchs() {

//      new CitiesLoadingTask().execute();


/*        Intent intent = new Intent(this, SearchActivity.class);
        query = intent.getStringExtra("query");
        startActivity(intent);*/

        AndroidNetworking.get(AppConstants.BASE_URL+"/team/loadEquipe")
                .build()
                .getAsObjectList(Equipe.class, new ParsedRequestListener<List<Equipe>>() {
                    @Override
                    public void onResponse(List<Equipe> matchs) {
                        mMatchAdapter.addAll(matchs);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Echec lecture des matchs", anError.getCause());
                    }
                });

    }

}
