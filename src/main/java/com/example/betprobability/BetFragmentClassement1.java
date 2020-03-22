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

import com.example.betprobability.com.betprobability.model.Equipe;
import com.example.betprobability.com.betprobability.model.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BetFragmentClassement1 extends Fragment {
    private static final String TAG = "BetFragmentClassement1";
    private TextView mMatchText;
    private List<Equipe> mMatch;
    private LinearLayout mLayout;

    public BetFragmentClassement1(List<Equipe> mMatch) {
        this.mMatch = mMatch;
    }

    public BetFragmentClassement1() {
    }

    public static final Comparator<Equipe> EQUIPE = Comparator.comparing(Equipe::getClassement);

    public class EquipeComparator implements Comparator<Equipe> {
        public int compare(Equipe equipe1, Equipe equipe2) {

            return EQUIPE.compare(equipe1,equipe2);
        }
    }

    public void getList(List<Equipe> equipe){
        Collections.sort(equipe, new EquipeComparator());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //String entree = getArguments().getString("menutext");
        View view = inflater.inflate(R.layout.fragment_classement, container, false);
        mMatchText = view.findViewById(R.id.textView20);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        getList(mMatch);
            List<Match> matchs = new ArrayList<>();
        for(int i=0;i<mMatch.size();i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("Equipe", mMatch.get(i).getEquipe());
            hm.put("Classement", Integer.toString(mMatch.get(i).getClassement()));
            aList.add(hm);
        }
        String[] from = { "Equipe","Classement"};

        int[] to = { R.id.Equipe,R.id.Classement};
        ListView list = view.findViewById(R.id.listViewClassement);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_fragment_classement, from, to);
        list.setAdapter(adapter);
//        mMatchText.setText(mMatch.getHistoriqueConfrontation().get(i).getEquipe1().getEquipe() + " : " + mMatch.getHistoriqueConfrontation().get(i).getScoredom() + " - " + mMatch.getHistoriqueConfrontation().get(i).getScoreext() + " : " + mMatch.getHistoriqueConfrontation().get(i).getEquipe2().getEquipe());

        return view;
    }

}