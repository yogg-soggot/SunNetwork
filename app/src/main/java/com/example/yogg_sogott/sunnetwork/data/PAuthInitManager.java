package com.example.yogg_sogott.sunnetwork.data;

import android.app.Application;

public class PAuthInitManager extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        PseudoAuthentication.init(this);



    }
}
