package com.example.betprobability;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntermediateAdminActivity extends BaseActivity {

    private Button mButtonAdminMatch;
    private Button mButtonAdminEquipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_intermediate);
        mButtonAdminMatch = findViewById(R.id.buttonadminmatch);
        mButtonAdminEquipe = findViewById(R.id.buttonadminequipe);
        mButtonAdminMatch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onMatchSelected();
                    }
                });

        mButtonAdminEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEquipeSelected();
            }
        });


    }


    private void onMatchSelected() {
        Intent intent = new Intent(this,MatchAdminActivity.class);

        startActivity(intent);

    }

    private void onEquipeSelected() {
        Intent intent = new Intent(this,EquipeAdminActivity.class);

        startActivity(intent);

    }


    @Override
    protected void onStart() {
        super.onStart();
    }
    }
