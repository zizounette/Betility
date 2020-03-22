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

import com.example.betprobability.com.betprobability.model.StatsFinales;
import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConfrontationActivity extends BaseActivity implements Serializable {

    private static final String TAG = "DetailActivity";
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

    private StatsFinales mMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrontatation);

/*        mTextChef = findViewById(R.id.text_chef);
        mTextAddress = findViewById(R.id.text_adress);
        mTextStyle = findViewById(R.id.text_style);
        mTextHours1 = findViewById(R.id.text_hours);
        mTextHours2 = findViewById(R.id.text_hours2);
        mTextPayment = findViewById(R.id.text_payment);
        mTextGetting = findViewById(R.id.text_getting);
        mTextParking = findViewById(R.id.text_parking);*/

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.mytabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setViewPager(ViewPager viewPager) {
        ConfrontationActivity.ViewPagerAdapter adapter = new ConfrontationActivity.ViewPagerAdapter(getSupportFragmentManager());
        Intent intent = getIntent();
        Bundle bundle2 = intent.getExtras();
        StatsFinales stats = (StatsFinales) bundle2.getSerializable("StatsFinales");


        this.mMatch = stats;

        BetFragment1 fragEnt = new BetFragment1(mMatch);
        BetFragment2 fragEnt2 = new BetFragment2(mMatch);
        BetFragment3 fragEnt3 = new BetFragment3(mMatch);
        adapter.addFragment(fragEnt, "Confrontations");
        adapter.addFragment(fragEnt2, "Confrontations Dom");
        adapter.addFragment(fragEnt3, "Confrontations Ext");
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
