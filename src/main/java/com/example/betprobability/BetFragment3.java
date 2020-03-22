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

public class BetFragment3 extends Fragment {
    private TextView mMatchText;
    private StatsFinales mMatch;
    private LinearLayout mLayout;

    public BetFragment3(StatsFinales mMatch) {
        this.mMatch = mMatch;
    }

    public BetFragment3() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //String entree = getArguments().getString("menutext");
        View view = inflater.inflate(R.layout.fragment_confrontation_ext, container, false);
        mMatchText = view.findViewById(R.id.textView10);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<mMatch.getHistoriqueConfrontationExt().size();i++){
            if(!mMatch.getHistoriqueConfrontationExt().get(i).getResultat().equals("U")) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("equipe1ext", mMatch.getHistoriqueConfrontationExt().get(i).getEquipe1().getEquipe());
                hm.put("scoredomext", Integer.toString(mMatch.getHistoriqueConfrontationExt().get(i).getScoredom()));
                hm.put("equipe2ext", mMatch.getHistoriqueConfrontationExt().get(i).getEquipe2().getEquipe());
                hm.put("scoreextext", Integer.toString(mMatch.getHistoriqueConfrontationExt().get(i).getScoreext()));
                aList.add(hm);
            }
        }
        String[] from = { "equipe1ext","scoredomext","scoreextext","equipe2ext"};

        int[] to = { R.id.equipe1ext,R.id.scoredomext,R.id.scoreextext,R.id.equipe2ext};
        ListView list = view.findViewById(R.id.listViewConfrontationsExt);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_fragment3, from, to);
        list.setAdapter(adapter);
//        mMatchText.setText(mMatch.getHistoriqueConfrontation().get(i).getEquipe1().getEquipe() + " : " + mMatch.getHistoriqueConfrontation().get(i).getScoredom() + " - " + mMatch.getHistoriqueConfrontation().get(i).getScoreext() + " : " + mMatch.getHistoriqueConfrontation().get(i).getEquipe2().getEquipe());

        return view;
    }
}
