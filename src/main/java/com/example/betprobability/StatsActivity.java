package com.example.betprobability;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.widget.ANImageView;
import com.example.betprobability.com.betprobability.model.Equipe;
import com.example.betprobability.com.betprobability.model.EquipeContainer;
import com.example.betprobability.com.betprobability.model.Match;
import com.example.betprobability.com.betprobability.model.StatsFinales;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class StatsActivity extends BaseActivity implements Serializable {

    public static final String TAG = "StatsActivity";
    private Button mEquipe1;
    private Button mEquipe2;
    private ANImageView mImageTeam1;
    private ANImageView mImageTeam2;
    private Button mProbability1;
    private Button mProbabilityN;
    private Button mProbability2;
    private TextView mProno;
    private Button mVictoryDom1;
    private Button mVictoryDom2;
    private Button mVictoryDom3;
    private Button mVictoryDom4;
    private Button mVictoryDom5;
    private Button mVictoryExt1;
    private Button mVictoryExt2;
    private Button mVictoryExt3;
    private Button mVictoryExt4;
    private Button mVictoryExt5;
    public ANImageView mImageViewEquipe1;
    public ANImageView mImageViewEquipe2;
    public ANImageView mImageViewEquipe3;
    public ANImageView mImageViewEquipe4;
    public ANImageView mImageViewEquipe5;
    public ANImageView mImageViewEquipe6;
    public ANImageView mImageViewEquipe7;
    public ANImageView mImageViewEquipe8;
    public ANImageView mImageViewEquipe9;
    public ANImageView mImageViewEquipe10;
    public ANImageView mImageViewEquipe11;
    public ANImageView mImageViewEquipe12;
    public ANImageView mImageViewEquipe13;
    public ANImageView mImageViewEquipe14;
    public ANImageView mImageViewEquipe15;
    public ANImageView mImageViewEquipe16;
    public ANImageView mImageViewEquipe17;
    public ANImageView mImageViewEquipe18;
    public ANImageView mImageViewEquipe19;
    public ANImageView mImageViewEquipe20;
    private Button mVictoryDomDom1;
/*    private Button mVictoryDomDom2;
    private Button mVictoryDomDom3;
    private Button mVictoryDomDom4;
    private Button mVictoryDomDom5;
    private Button mVictoryExtExt1;
    private Button mVictoryExtExt2;
    private Button mVictoryExtExt3;
    private Button mVictoryExtExt4;
    private Button mVictoryExtExt5;
    private PieChartView pieChartView1;
    private PieChartView pieChartView2; */
//    private TextProgressBar textProgress;

    private StatsFinales stats;
    private Match match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

//        textProgress = findViewById(R.id.progressBar1);
        mImageTeam1 = findViewById(R.id.image_equipeOne);
        mImageTeam2 = findViewById(R.id.image_equipeTwo);
        mEquipe1 = findViewById(R.id.button3);
        mEquipe2 = findViewById(R.id.button4);
        mProbability1 = findViewById(R.id.button13);
        mProbabilityN = findViewById(R.id.button11);
        mProbability2 = findViewById(R.id.button10);
        mProno = findViewById(R.id.textViewConseil);
        mVictoryDom1 = findViewById(R.id.button18);
        mVictoryDom2 = findViewById(R.id.button17);
        mVictoryDom3 = findViewById(R.id.button16);
        mVictoryDom4 = findViewById(R.id.button15);
        mVictoryDom5 = findViewById(R.id.button14);
        mVictoryExt1 = findViewById(R.id.button18ext);
        mVictoryExt2 = findViewById(R.id.button17ext);
        mVictoryExt3 = findViewById(R.id.button16ext);
        mVictoryExt4 = findViewById(R.id.button15ext);
        mVictoryExt5 = findViewById(R.id.button14ext);
        mImageViewEquipe1 = findViewById(R.id.image_equipe1);
        mImageViewEquipe2 = findViewById(R.id.image_equipe2);
        mImageViewEquipe3 = findViewById(R.id.image_equipe12);
        mImageViewEquipe4 = findViewById(R.id.image_equipe22);
        mImageViewEquipe5 = findViewById(R.id.image_equipe13);
        mImageViewEquipe6 = findViewById(R.id.image_equipe23);
        mImageViewEquipe7 = findViewById(R.id.image_equipe14);
        mImageViewEquipe8 = findViewById(R.id.image_equipe24);
        mImageViewEquipe9 = findViewById(R.id.image_equipe15);
        mImageViewEquipe10 = findViewById(R.id.image_equipe25);
        mImageViewEquipe11 = findViewById(R.id.image_equipe1ext);
        mImageViewEquipe12 = findViewById(R.id.image_equipe2ext);
        mImageViewEquipe13 = findViewById(R.id.image_equipe12ext);
        mImageViewEquipe14 = findViewById(R.id.image_equipe22ext);
        mImageViewEquipe15 = findViewById(R.id.image_equipe13ext);
        mImageViewEquipe16 = findViewById(R.id.image_equipe23ext);
        mImageViewEquipe17 = findViewById(R.id.image_equipe14ext);
        mImageViewEquipe18 = findViewById(R.id.image_equipe24ext);
        mImageViewEquipe19 = findViewById(R.id.image_equipe15ext);
        mImageViewEquipe20 = findViewById(R.id.image_equipe25ext);
/*      mVictoryDomDom1 = findViewById(R.id.button31);
        mVictoryDomDom2 = findViewById(R.id.button30);
        mVictoryDomDom3 = findViewById(R.id.button29);
        mVictoryDomDom4 = findViewById(R.id.button28);
        mVictoryDomDom5 = findViewById(R.id.button27);
        mVictoryExtExt1 = findViewById(R.id.button36);
        mVictoryExtExt2 = findViewById(R.id.button35);
        mVictoryExtExt3 = findViewById(R.id.button34);
        mVictoryExtExt4 = findViewById(R.id.button33);
        mVictoryExtExt5 = findViewById(R.id.button32);
        pieChartView1 = findViewById(R.id.chart1);
        pieChartView2 = findViewById(R.id.chart2); */
//        mEquipe2 = findViewById(R.id.textView2);
//        mTextDescription.setMovementMethod(new ScrollingMovementMethod());
//        mClassementEquipe1 = findViewById(R.id.textView4);
//        mClassementEquipe2 = findViewById(R.id.text_description);
/*        mSerieEquipe1 = findViewById(R.id.text_style);
        mSerieEquipe2 = findViewById(R.id.text_hours);
        mSerieDomEquipe1 = findViewById(R.id.text_hours2);
        mSerieExtEquipe1 = findViewById(R.id.text_payment); */
//         mProbabilityEquipe1 = findViewById(R.id.textView3);
//         mList = findViewById(R.id.textView4);
//         mProbabilityDraw = findViewById(R.id.textView5);
//         mProbabilityEquipe2 = findViewById(R.id.textView6);
/*        mProbabilityDraw = findViewById(R.id.textView4);

        mConseil = findViewById(R.id.text_parking); */

        loadStats();
    }

    private void loadStats() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Match stats = (Match) bundle.getSerializable("Match");

        onStatsLoaded(stats);

    }

    private void onStatsLoaded(Match match) {
        this.match = match;
        AndroidNetworking.get(AppConstants.BASE_URL+"/bet/"+match.getEquipe1().getId()+"/"+match.getEquipe2().getId())
                .addQueryParameter("id",Integer.toString(match.getEquipe1().getId()))
                .addQueryParameter("id2",Integer.toString(match.getEquipe2().getId()))
                .build()
                .getAsObject(StatsFinales.class, new ParsedRequestListener<StatsFinales>() {
                    @Override
                    public void onResponse(final StatsFinales statistique) {
                        Log.d("Stats : ", "Liste stats: " + statistique);
                        DecimalFormat df = new DecimalFormat("##.###");
                        df.setRoundingMode(RoundingMode.HALF_UP);
                        mEquipe1.setText(Integer.toString(statistique.getMatch().getEquipe1().getClassement()));
                        mEquipe2.setText(Integer.toString(statistique.getMatch().getEquipe2().getClassement()));
                        mImageTeam1.setImageUrl(AppConstants.BASE_URL + "/images/" + statistique.getMatch().getEquipe1().getId());
                        mImageTeam2.setImageUrl(AppConstants.BASE_URL + "/images/" + statistique.getMatch().getEquipe2().getId());
                        mProbability1.setText("1 : " + df.format(statistique.getProbabilityVictoryDom()*100) + " %");
                        mProbabilityN.setText("N : " + df.format(statistique.getProbabilityDraw()*100) + " %");
                        mProbability2.setText("2 : " + df.format(statistique.getProbabilityVictoryExt()*100) + " %");
                        int valueVic = (int)(Math.round(statistique.getProbabilityVictoryDom()*100));
                        int valueDraw = (int)(Math.round(statistique.getProbabilityDraw()*100));
                        Log.d("la : ", "alors : " + valueVic);
                        Log.d("la : ", "alors : " + valueDraw);
                        buttonAndTeams1(statistique.getMatch().getEquipe1().getId());
                        buttonAndTeams2(statistique.getMatch().getEquipe2().getId());
//                        textProgress.setProgress(valueVic);
//                        textProgress.setSecondaryProgress(valueVic + valueDraw);

                       if((statistique.getProbabilityVictoryDom() > (2*statistique.getProbabilityDraw())) && (statistique.getProbabilityVictoryDom() > (2* statistique.getProbabilityVictoryExt()))){
                            mProno.setText("Pronostic conseillé : Victoire de " + statistique.getMatch().getEquipe1().getEquipe());
                            mProbabilityN.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                            mProbability2.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                            mProbability1.setBackgroundColor(getResources().getColor(R.color.camaieuvert));
                        }else if((statistique.getProbabilityDraw() > (2*statistique.getProbabilityVictoryDom())) && (statistique.getProbabilityDraw() > (2* statistique.getProbabilityVictoryExt()))){
                            mProno.setText("Pronostic conseillé : Match nul");
                           mProbability1.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                           mProbability2.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                           mProbabilityN.setBackgroundColor(getResources().getColor(R.color.camaieuvert));

                       }else if ((statistique.getProbabilityVictoryExt() > (2*statistique.getProbabilityVictoryDom())) && (statistique.getProbabilityVictoryExt() > (2* statistique.getProbabilityDraw()))) {
                            mProno.setText("Pronostic conseillé : Victoire de " + statistique.getMatch().getEquipe2().getEquipe());
                           mProbability1.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                           mProbabilityN.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                           mProbability2.setBackgroundColor(getResources().getColor(R.color.camaieuvert));
                       }else if(statistique.getProbabilityVictoryDom() > statistique.getProbabilityVictoryExt()){
                            mProno.setText("Pronostic conseillé : Match nul ou " + statistique.getMatch().getEquipe1().getEquipe());
                           mProbability2.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                           mProbability1.setBackgroundColor(getResources().getColor(R.color.camaieuvert));
                           mProbabilityN.setBackgroundColor(getResources().getColor(R.color.camaieuvert));
                       }else if(statistique.getProbabilityVictoryExt() > statistique.getProbabilityVictoryDom()){
                            mProno.setText("Pronostic conseillé : Match nul ou " + statistique.getMatch().getEquipe2().getEquipe());
                           mProbability1.setBackgroundColor(getResources().getColor(R.color.camaieurouge));
                           mProbabilityN.setBackgroundColor(getResources().getColor(R.color.camaieuvert));
                           mProbability2.setBackgroundColor(getResources().getColor(R.color.camaieuvert));
                       }

                        if(statistique.getFormeFiveMatchsEquipeDom().get(0).equals("V")){
                            mVictoryDom5.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryDom5.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(0).equals("N")){
                            mVictoryDom5.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryDom5.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(0).equals("D")){
                            mVictoryDom5.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryDom5.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeDom().get(1).equals("V")){
                            mVictoryDom4.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryDom4.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(1).equals("N")){
                            mVictoryDom4.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryDom4.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(1).equals("D")){
                            mVictoryDom4.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryDom4.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeDom().get(2).equals("V")){
                            mVictoryDom3.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryDom3.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(2).equals("N")){
                            mVictoryDom3.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryDom3.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(2).equals("D")){
                            mVictoryDom3.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryDom3.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeDom().get(3).equals("V")){
                            mVictoryDom2.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryDom2.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(3).equals("N")){
                            mVictoryDom2.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryDom2.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(3).equals("D")){
                            mVictoryDom2.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryDom2.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeDom().get(4).equals("V")){
                            mVictoryDom1.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryDom1.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(4).equals("N")){
                            mVictoryDom1.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryDom1.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeDom().get(4).equals("D")){
                            mVictoryDom1.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryDom1.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeExt().get(0).equals("V")){
                            mVictoryExt5.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryExt5.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(0).equals("N")){
                            mVictoryExt5.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryExt5.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(0).equals("D")){
                            mVictoryExt5.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryExt5.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeExt().get(1).equals("V")){
                            mVictoryExt4.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryExt4.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(1).equals("N")){
                            mVictoryExt4.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryExt4.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(1).equals("D")){
                            mVictoryExt4.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryExt4.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeExt().get(2).equals("V")){
                            mVictoryExt3.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryExt3.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(2).equals("N")){
                            mVictoryExt3.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryExt3.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(2).equals("D")){
                            mVictoryExt3.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryExt3.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeExt().get(3).equals("V")){
                            mVictoryExt2.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryExt2.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(3).equals("N")){
                            mVictoryExt2.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryExt2.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(3).equals("D")){
                            mVictoryExt2.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryExt2.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsEquipeExt().get(4).equals("V")){
                            mVictoryExt1.setBackground(getResources().getDrawable(R.drawable.apple_button));
                            mVictoryExt1.setText("V");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(4).equals("N")){
                            mVictoryExt1.setBackground(getResources().getDrawable(R.drawable.orange_button));
                            mVictoryExt1.setText("N");
                        }else if(statistique.getFormeFiveMatchsEquipeExt().get(4).equals("D")){
                            mVictoryExt1.setBackground(getResources().getDrawable(R.drawable.red_button));
                            mVictoryExt1.setText("D");
                        }
 /*                       if(statistique.getFormeFiveMatchsDomEquipeDom().get(0).equals("V")){
                            mVictoryDomDom5.setBackgroundResource(R.color.green);
                            mVictoryDomDom5.setText("V");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(0).equals("N")){
                            mVictoryDomDom5.setBackgroundResource(R.color.orange);
                            mVictoryDomDom5.setText("N");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(0).equals("D")){
                            mVictoryDomDom5.setBackgroundResource(R.color.red);
                            mVictoryDomDom5.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsDomEquipeDom().get(1).equals("V")){
                            mVictoryDomDom4.setBackgroundResource(R.color.green);
                            mVictoryDomDom4.setText("V");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(1).equals("N")){
                            mVictoryDomDom4.setBackgroundResource(R.color.orange);
                            mVictoryDomDom4.setText("N");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(1).equals("D")){
                            mVictoryDomDom4.setBackgroundResource(R.color.red);
                            mVictoryDomDom4.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsDomEquipeDom().get(2).equals("V")){
                            mVictoryDomDom3.setBackgroundResource(R.color.green);
                            mVictoryDomDom3.setText("V");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(2).equals("N")){
                            mVictoryDomDom3.setBackgroundResource(R.color.orange);
                            mVictoryDomDom3.setText("N");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(2).equals("D")){
                            mVictoryDomDom3.setBackgroundResource(R.color.red);
                            mVictoryDomDom3.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsDomEquipeDom().get(3).equals("V")){
                            mVictoryDomDom2.setBackgroundResource(R.color.green);
                            mVictoryDomDom2.setText("V");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(3).equals("N")){
                            mVictoryDomDom2.setBackgroundResource(R.color.orange);
                            mVictoryDomDom2.setText("N");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(3).equals("D")){
                            mVictoryDomDom2.setBackgroundResource(R.color.red);
                            mVictoryDomDom2.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsDomEquipeDom().get(4).equals("V")){
                            mVictoryDomDom1.setBackgroundResource(R.color.green);
                            mVictoryDomDom1.setText("V");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(4).equals("N")){
                            mVictoryDomDom1.setBackgroundResource(R.color.orange);
                            mVictoryDomDom1.setText("N");
                        }else if(statistique.getFormeFiveMatchsDomEquipeDom().get(4).equals("D")){
                            mVictoryDomDom1.setBackgroundResource(R.color.red);
                            mVictoryDomDom1.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsExtEquipeExt().get(0).equals("V")){
                            mVictoryExtExt5.setBackgroundResource(R.color.green);
                            mVictoryExtExt5.setText("V");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(0).equals("N")){
                            mVictoryExtExt5.setBackgroundResource(R.color.orange);
                            mVictoryExtExt5.setText("N");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(0).equals("D")){
                            mVictoryExtExt5.setBackgroundResource(R.color.red);
                            mVictoryExtExt5.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsExtEquipeExt().get(1).equals("V")){
                            mVictoryExtExt4.setBackgroundResource(R.color.green);
                            mVictoryExtExt4.setText("V");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(1).equals("N")){
                            mVictoryExtExt4.setBackgroundResource(R.color.orange);
                            mVictoryExtExt4.setText("N");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(1).equals("D")){
                            mVictoryExtExt4.setBackgroundResource(R.color.red);
                            mVictoryExtExt4.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsExtEquipeExt().get(2).equals("V")){
                            mVictoryExtExt3.setBackgroundResource(R.color.green);
                            mVictoryExtExt3.setText("V");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(2).equals("N")){
                            mVictoryExtExt3.setBackgroundResource(R.color.orange);
                            mVictoryExtExt3.setText("N");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(2).equals("D")){
                            mVictoryExtExt3.setBackgroundResource(R.color.red);
                            mVictoryExtExt3.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsExtEquipeExt().get(3).equals("V")){
                            mVictoryExtExt2.setBackgroundResource(R.color.green);
                            mVictoryExtExt2.setText("V");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(3).equals("N")){
                            mVictoryExtExt2.setBackgroundResource(R.color.orange);
                            mVictoryExtExt2.setText("N");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(3).equals("D")){
                            mVictoryExtExt2.setBackgroundResource(R.color.red);
                            mVictoryExtExt2.setText("D");
                        }
                        if(statistique.getFormeFiveMatchsExtEquipeExt().get(4).equals("V")){
                            mVictoryExtExt1.setBackgroundResource(R.color.green);
                            mVictoryExtExt1.setText("V");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(4).equals("N")){
                            mVictoryExtExt1.setBackgroundResource(R.color.orange);
                            mVictoryExtExt1.setText("N");
                        }else if(statistique.getFormeFiveMatchsExtEquipeExt().get(4).equals("D")){
                            mVictoryExtExt1.setBackgroundResource(R.color.red);
                            mVictoryExtExt1.setText("D");
                        }
                        List<SliceValue> pieData = new ArrayList<>();
                        List<SliceValue> pieDataDom = new ArrayList<>();
                        int numberVictory = 0;
                        int numberDraw = 0;
                        int numberLose = 0;
                        int numberVictoryDom = 0;
                        int numberDrawDom = 0;
                        int numberLoseDom = 0;
                        for(int i =0; i<statistique.getHistoriqueConfrontation().size(); i++){
                            if(statistique.getHistoriqueConfrontation().get(i).getEquipe1().getEquipe().equals(statistique.getMatch().getEquipe1().getEquipe())){
                                if(!statistique.getHistoriqueConfrontation().get(i).getResultat().equals("U")) {
                                    if (statistique.getHistoriqueConfrontation().get(i).getScoredom() > statistique.getHistoriqueConfrontation().get(i).getScoreext()) {
                                        numberVictory = numberVictory + 1;
                                        numberVictoryDom = numberVictoryDom + 1;
                                    } else if (statistique.getHistoriqueConfrontation().get(i).getScoredom() < statistique.getHistoriqueConfrontation().get(i).getScoreext()) {
                                        numberLose = numberLose + 1;
                                        numberLoseDom = numberLoseDom + 1;
                                    } else if (statistique.getHistoriqueConfrontation().get(i).getScoredom() == statistique.getHistoriqueConfrontation().get(i).getScoreext()) {
                                        numberDraw = numberDraw + 1;
                                        numberDrawDom = numberDrawDom + 1;
                                    }
                                }
                            }else if(statistique.getHistoriqueConfrontation().get(i).getEquipe2().getEquipe().equals(statistique.getMatch().getEquipe1().getEquipe())) {
                                if (!statistique.getHistoriqueConfrontation().get(i).getResultat().equals("U")) {
                                    if (statistique.getHistoriqueConfrontation().get(i).getScoredom() > statistique.getHistoriqueConfrontation().get(i).getScoreext()) {
                                        numberLose = numberLose + 1;
                                    } else if (statistique.getHistoriqueConfrontation().get(i).getScoredom() < statistique.getHistoriqueConfrontation().get(i).getScoreext()) {
                                        numberVictory = numberVictory + 1;
                                    } else if (statistique.getHistoriqueConfrontation().get(i).getScoredom() == statistique.getHistoriqueConfrontation().get(i).getScoreext()) {
                                        numberDraw = numberDraw + 1;
                                    }
                                }
                            }
                        }

                        pieData.add(new SliceValue(numberVictory, Color.GREEN));
                        pieData.add(new SliceValue(numberDraw, Color.YELLOW));
                        pieData.add(new SliceValue(numberLose, Color.RED));
                        pieDataDom.add(new SliceValue(numberVictoryDom, Color.GREEN));
                        pieDataDom.add(new SliceValue(numberDrawDom, Color.YELLOW));
                        pieDataDom.add(new SliceValue(numberLoseDom, Color.RED));

                        PieChartData pieChartData = new PieChartData(pieData);
                        PieChartData pieChartDataDom = new PieChartData(pieDataDom);

                        pieChartView1.setPieChartData(pieChartData);
                        pieChartView2.setPieChartData(pieChartDataDom);

                        pieChartView1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                onMatchSelected(statistique);
                            }
                        });
                        pieChartView2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                onMatchSelected(statistique);
                            }
                        }); */
                        mEquipe1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                AndroidNetworking.get(AppConstants.BASE_URL+"/team/loadEquipe")
                                        .build()
                                        .getAsObjectList(Equipe.class, new ParsedRequestListener<List<Equipe>>() {
                                            @Override
                                            public void onResponse(final List<Equipe> equipeList) {
                                                EquipeContainer equipe = new EquipeContainer();
                                                equipe.setEquipe(equipeList);
                                                onClassementSelected(equipe);
                                            }


                                            @Override
                                            public void onError(ANError anError) {
                                                Log.e(TAG, "Echec lecture des equipes", anError.getCause());
                                            }
                                        });
                            }
                        });
                        mEquipe2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                AndroidNetworking.get(AppConstants.BASE_URL+"/team/loadEquipe")
                                        .build()
                                        .getAsObjectList(Equipe.class, new ParsedRequestListener<List<Equipe>>() {
                                            @Override
                                            public void onResponse(final List<Equipe> equipeList) {
                                                EquipeContainer equipe = new EquipeContainer();
                                                equipe.setEquipe(equipeList);
                                                onClassementSelected(equipe);
                                            }


                                            @Override
                                            public void onError(ANError anError) {
                                                Log.e(TAG, "Echec lecture des equipes", anError.getCause());
                                            }
                                        });
                            }
                        });

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Echec lecture des stats", anError.getCause());
                    }
                });

    }

    private void onMatchSelected(StatsFinales stats) {
        Intent intent = new Intent(this, ConfrontationActivity.class);
        intent.putExtra("StatsFinales", stats);

        startActivity(intent);
    }


    private void onClassementSelected(EquipeContainer equipelist) {
        Intent intent = new Intent(this, ClassementActivity.class);
        intent.putExtra("Equipe", equipelist);
        startActivity(intent);
    }

    private void buttonAndTeams1(int idEquipe) {
        AndroidNetworking.get(AppConstants.BASE_URL+"/match/loadlastmatch/"+idEquipe+"/6")
                .addQueryParameter("id",Integer.toString(idEquipe))
                .addQueryParameter("numberoflastmatch","6")
                .build()
                .getAsObjectList(Match.class, new ParsedRequestListener<List<Match>>() {
                    @Override
                    public void onResponse(final List<Match> matchs) {
                        mImageViewEquipe1.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(4).getEquipe1().getId());
                        mImageViewEquipe2.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(4).getEquipe2().getId());
                        mImageViewEquipe3.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(3).getEquipe1().getId());
                        mImageViewEquipe4.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(3).getEquipe2().getId());
                        mImageViewEquipe5.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(2).getEquipe1().getId());
                        mImageViewEquipe6.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(2).getEquipe2().getId());
                        mImageViewEquipe7.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(1).getEquipe1().getId());
                        mImageViewEquipe8.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(1).getEquipe2().getId());
                        mImageViewEquipe9.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(0).getEquipe1().getId());
                        mImageViewEquipe10.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(0).getEquipe2().getId());
                        mVictoryDom1.setText(matchs.get(4).getResultat());
                        mVictoryDom2.setText(matchs.get(3).getResultat());
                        mVictoryDom3.setText(matchs.get(2).getResultat());
                        mVictoryDom4.setText(matchs.get(1).getResultat());
                        mVictoryDom5.setText(matchs.get(0).getResultat());

                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Echec lecture des equipes", anError.getCause());
                    }
                });

    }

    private void buttonAndTeams2(int idEquipe) {
        AndroidNetworking.get(AppConstants.BASE_URL+"/match/loadlastmatch/"+idEquipe+"/6")
                .addQueryParameter("id",Integer.toString(idEquipe))
                .addQueryParameter("numberoflastmatch","6")
                .build()
                .getAsObjectList(Match.class, new ParsedRequestListener<List<Match>>() {
                    @Override
                    public void onResponse(final List<Match> matchs) {
                        mImageViewEquipe11.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(4).getEquipe1().getId());
                        mImageViewEquipe12.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(4).getEquipe2().getId());
                        mImageViewEquipe13.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(3).getEquipe1().getId());
                        mImageViewEquipe14.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(3).getEquipe2().getId());
                        mImageViewEquipe15.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(2).getEquipe1().getId());
                        mImageViewEquipe16.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(2).getEquipe2().getId());
                        mImageViewEquipe17.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(1).getEquipe1().getId());
                        mImageViewEquipe18.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(1).getEquipe2().getId());
                        mImageViewEquipe19.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(0).getEquipe1().getId());
                        mImageViewEquipe20.setImageUrl(AppConstants.BASE_URL + "/images/" + matchs.get(0).getEquipe2().getId());
                        mVictoryExt1.setText(matchs.get(4).getResultat());
                        mVictoryExt2.setText(matchs.get(3).getResultat());
                        mVictoryExt3.setText(matchs.get(2).getResultat());
                        mVictoryExt4.setText(matchs.get(1).getResultat());
                        mVictoryExt5.setText(matchs.get(0).getResultat());

                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Echec lecture des equipes", anError.getCause());
                    }
                });

    }

}