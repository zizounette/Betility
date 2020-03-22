package com.example.betprobability;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity {

    private ChampionnatAdapter mChampionnatAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private EditText mEditTextQuery;
    private Button mButtonAdmin;
    private MatchAdapter.SelectedListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BetApplication app = (BetApplication) getApplication();
        if(app.getCustomer() != null){
            if(app.getCustomer().getStatut().equals("A")){
                mButtonAdmin = findViewById(R.id.buttonAdmin);
                mButtonAdmin.setVisibility(View.VISIBLE);
                mButtonAdmin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onAdminSelected();
                    }
                });
            }else{
                mButtonAdmin = findViewById(R.id.buttonAdmin);
                mButtonAdmin.setVisibility(View.INVISIBLE);
            }
        }
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mChampionnatAdapter = new ChampionnatAdapter(new ChampionnatAdapter.selectedListener() {
            @Override
            public void championnatSelected() {
                onChampionnatSelected();
            }
        });
        mRecyclerView.setAdapter(mChampionnatAdapter);

    }
        private void onChampionnatSelected() {
            Intent intent = new Intent(this,MatchActivity.class);

            startActivity(intent);

        }

    private void onAdminSelected() {
        Intent intent = new Intent(this,IntermediateAdminActivity.class);

        startActivity(intent);

    }


    @Override
    protected void onStart() {
        super.onStart();
    }
    }
