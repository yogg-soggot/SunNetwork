package com.example.yogg_sogott.sunnetwork.data;

import android.app.Application;



public class PAuthInitManager extends Application {




    @Override
    public void onCreate(){
        super.onCreate();
        /* Shared references should be called from context,
         * to get the context i need to receive it from any class
         * extended from application when app is started
         */
        PseudoAuthentication.init(this);








    }
}
