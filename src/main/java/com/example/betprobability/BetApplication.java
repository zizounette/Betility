package com.example.betprobability;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.example.betprobability.com.betprobability.model.User;

public class BetApplication extends Application {

    private User customer;


    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
    }


    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

}
