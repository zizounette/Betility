package com.example.betprobability;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.betprobability.com.betprobability.model.StatsFinales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BetFragment1 extends Fragment {
    private TextView mMatchText;
    private StatsFinales mMatch;
    private LinearLayout mLayout;

    public BetFragment1(StatsFinales mMatch) {
        this.mMatch = mMatch;
    }

    public BetFragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //String entree = getArguments().getString("menutext");
        View view = inflater.inflate(R.layout.fragment_confrontations, container, false);
        mMatchText = view.findViewById(R.id.textView10);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<mMatch.getHistoriqueConfrontation().size();i++){
            if(!mMatch.getHistoriqueConfrontation().get(i).getResultat().equals("U")) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("equipe1", mMatch.getHistoriqueConfrontation().get(i).getEquipe1().getEquipe());
                hm.put("scoredom", Integer.toString(mMatch.getHistoriqueConfrontation().get(i).getScoredom()));
                hm.put("equipe2", mMatch.getHistoriqueConfrontation().get(i).getEquipe2().getEquipe());
                hm.put("scoreext", Integer.toString(mMatch.getHistoriqueConfrontation().get(i).getScoreext()));
                aList.add(hm);
            }
        }
        String[] from = { "equipe1","scoredom","scoreext","equipe2"};

        int[] to = { R.id.equipe1,R.id.scoredom,R.id.scoreext,R.id.equipe2};
        ListView list = view.findViewById(R.id.listViewConfrontations);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_fragment, from, to);
        list.setAdapter(adapter);
//        mMatchText.setText(mMatch.getHistoriqueConfrontation().get(i).getEquipe1().getEquipe() + " : " + mMatch.getHistoriqueConfrontation().get(i).getScoredom() + " - " + mMatch.getHistoriqueConfrontation().get(i).getScoreext() + " : " + mMatch.getHistoriqueConfrontation().get(i).getEquipe2().getEquipe());

        return view;
    }

}