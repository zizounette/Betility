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

public class BetFragmentClassement2 extends Fragment {
    private static final String TAG = "BetFragmentClassement2";
    private TextView mMatchText;
    private List<Equipe> mMatch;
    private LinearLayout mLayout;

    public BetFragmentClassement2(List<Equipe> mMatch) {
        this.mMatch = mMatch;
    }

    public BetFragmentClassement2() {
    }

    public static final Comparator<Equipe> EQUIPE_DOM = Comparator.comparing(Equipe::getClassementDom);

    public class EquipeComparatorDom implements Comparator<Equipe> {
        public int compare(Equipe equipe1, Equipe equipe2) {

            return EQUIPE_DOM.compare(equipe1,equipe2);
        }
    }

    public void getListDom(List<Equipe> equipeDom){
        Collections.sort(equipeDom, new EquipeComparatorDom());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //String entree = getArguments().getString("menutext");
        View view = inflater.inflate(R.layout.fragment_classement_dom, container, false);
        mMatchText = view.findViewById(R.id.textView20);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        getListDom(mMatch);
        List<Match> matchs = new ArrayList<>();
        for(int i=0;i<mMatch.size();i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("Equipedom", mMatch.get(i).getEquipe());
            hm.put("Classementdom", Integer.toString(mMatch.get(i).getClassementDom()));
            aList.add(hm);
        }
        String[] from = { "Equipedom","Classementdom"};

        int[] to = { R.id.Equipedom,R.id.Classementdom};
        ListView list = view.findViewById(R.id.listViewClassementDom);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_fragment2_classement, from, to);
        list.setAdapter(adapter);
//        mMatchText.setText(mMatch.getHistoriqueConfrontation().get(i).getEquipe1().getEquipe() + " : " + mMatch.getHistoriqueConfrontation().get(i).getScoredom() + " - " + mMatch.getHistoriqueConfrontation().get(i).getScoreext() + " : " + mMatch.getHistoriqueConfrontation().get(i).getEquipe2().getEquipe());

        return view;
    }

}