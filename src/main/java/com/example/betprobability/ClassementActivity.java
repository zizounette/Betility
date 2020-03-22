package com.example.betprobability;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.betprobability.com.betprobability.model.Equipe;
import com.example.betprobability.com.betprobability.model.EquipeContainer;
import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassementActivity extends BaseActivity implements Serializable {

    private static final String TAG = "ClassementActivity";
    private TextView mTextName;
    private TextView mTextDescription;
    private CarouselView mCarouselView;
    private TextView mTextChef;
    private TextView mTextAddress;
    private TextView mTextStyle;
    private TextView mTextHours1;
    private TextView mTextHours2;
    private TextView mTextPayment;
    private TextView mTextGetting;
    private TextView mTextParking;
    private LinearLayout mLinearLayout;
    private Button mBooking;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Equipe> mTeams = new ArrayList<>();
    private List<Equipe> mTeams2 = new ArrayList<>();
    private List<Equipe> mTeams3 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

/*        mTextChef = findViewById(R.id.text_chef);
        mTextAddress = findViewById(R.id.text_adress);
        mTextStyle = findViewById(R.id.text_style);
        mTextHours1 = findViewById(R.id.text_hours);
        mTextHours2 = findViewById(R.id.text_hours2);
        mTextPayment = findViewById(R.id.text_payment);
        mTextGetting = findViewById(R.id.text_getting);
        mTextParking = findViewById(R.id.text_parking);*/

        viewPager = (ViewPager) findViewById(R.id.viewpager20);
        setViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.mytabs20);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setViewPager(ViewPager viewPager) {
        ClassementActivity.ViewPagerAdapter adapter = new ClassementActivity.ViewPagerAdapter(getSupportFragmentManager());
        Intent intent = getIntent();
        Bundle bundle2 = intent.getExtras();
        EquipeContainer equipe = (EquipeContainer) bundle2.getSerializable("Equipe");
        List<Equipe> equipeList = equipe.getEquipe();
        List<Equipe> equipeListDom = equipe.getEquipe();
        List<Equipe> equipeListExt = equipe.getEquipe();

        mTeams = equipeList;
        mTeams2 = equipeListDom;
        mTeams3 = equipeListExt;


        BetFragmentClassement1 fragEnt = new BetFragmentClassement1(mTeams);
        BetFragmentClassement2 fragEnt2 = new BetFragmentClassement2(mTeams2);
        BetFragmentClassement3 fragEnt3 = new BetFragmentClassement3(mTeams3);
        adapter.addFragment(fragEnt, "Classement");
        adapter.addFragment(fragEnt2, "Classement Dom");
        adapter.addFragment(fragEnt3, "Classement Ext");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    }
