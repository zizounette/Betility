package com.example.betprobability;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseListener;
import com.example.betprobability.com.betprobability.model.Match;

import java.io.Serializable;

import okhttp3.Response;


public class AdminMatchActivity extends BaseActivity implements Serializable {

    public static final String TAG = "AdminMatchActivity";

    private Button mEquipe1;
    private Button mEquipe2;
    private Button mValider;
    private NumberPicker picker1;
    private NumberPicker picker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_adminupdate);
        mEquipe1 = findViewById(R.id.button39Admin);
        mEquipe2 = findViewById(R.id.button42Admin);
        picker1 = findViewById(R.id.score1Admin);
        picker2 = findViewById(R.id.score2Admin);
        mValider = findViewById(R.id.button43admin);

        loadMatch();

    }

    private void loadMatch() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Match stats = (Match) bundle.getSerializable("Match");

        onMatchLoaded(stats);

    }

    private void onMatchLoaded(Match stats) {

        mEquipe1.setText(stats.getEquipe1().getEquipe());
        mEquipe2.setText(stats.getEquipe2().getEquipe());
        picker1.setMinValue(0);
        picker1.setMaxValue(20);
        picker1.setWrapSelectorWheel(true);
        picker2.setMinValue(0);
        picker2.setMaxValue(20);
        picker2.setWrapSelectorWheel(true);

        mValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(stats);
            }
        });
    }

    private void validate(Match stats) {
        AndroidNetworking.get(AppConstants.BASE_URL+"/match/updatematch/"+stats.getId()+"/"+picker1.getValue()+"/"+picker2.getValue())
                .addQueryParameter("id",Integer.toString(stats.getId()))
                .addQueryParameter("score1",Integer.toString(picker1.getValue()))
                .addQueryParameter("score2",Integer.toString(picker2.getValue()))
                .build()
                .getAsOkHttpResponse(new OkHttpResponseListener() {
                    @Override
                    public void onResponse(Response response) {

                        finish();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Echec mise à jour match :" + anError.getErrorDetail() +anError.getErrorBody(), anError.getCause());
                    }
                });
    }

}
