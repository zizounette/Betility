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
import com.example.betprobability.com.betprobability.model.Equipe;

import java.io.Serializable;

import okhttp3.Response;


public class AdminEquipeActivity extends BaseActivity implements Serializable {

    public static final String TAG = "AdminMatchActivity";

    private Button mEquipe1;
    private Button mValider;
    private NumberPicker picker1;
    private NumberPicker picker2;
    private NumberPicker picker3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_adminupdate);
        mEquipe1 = findViewById(R.id.button60Admin);
        picker1 = findViewById(R.id.classement1Admin);
        picker2 = findViewById(R.id.classement2Admin);
        picker3 = findViewById(R.id.classement3Admin);
        mValider = findViewById(R.id.button43admin);

        loadMatch();

    }

    private void loadMatch() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Equipe stats = (Equipe) bundle.getSerializable("Equipe");

        onMatchLoaded(stats);

    }

    private void onMatchLoaded(Equipe stats) {

        mEquipe1.setText(stats.getEquipe());
        picker1.setMinValue(0);
        picker1.setMaxValue(20);
        picker1.setWrapSelectorWheel(true);
        picker2.setMinValue(0);
        picker2.setMaxValue(20);
        picker2.setWrapSelectorWheel(true);
        picker3.setMinValue(0);
        picker3.setMaxValue(20);
        picker3.setWrapSelectorWheel(true);

        mValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(stats);
            }
        });
    }

    private void validate(Equipe stats) {
        AndroidNetworking.get(AppConstants.BASE_URL+"/team/updateranking/"+stats.getId()+"/"+picker1.getValue()+"/"+picker2.getValue()+"/"+picker3.getValue())
                .addQueryParameter("id",Integer.toString(stats.getId()))
                .addQueryParameter("id2",Integer.toString(picker1.getValue()))
                .addQueryParameter("id3",Integer.toString(picker2.getValue()))
                .addQueryParameter("id4",Integer.toString(picker3.getValue()))
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
