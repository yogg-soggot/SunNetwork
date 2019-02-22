package com.example.yogg_sogott.sunnetwork.data;

import android.app.Application;

import com.example.yogg_sogott.sunnetwork.domain.AuthValidation;
import com.example.yogg_sogott.sunnetwork.presentation.CreateAccountPresenter;

public class PAuthInitManager extends Application {





    @Override
    public void onCreate(){
        super.onCreate();
        /* Shared references should be called from context,
         * to get the context i need to receive it from any class
         * extended from application when app is started
         */
        PseudoAuthentication.init(this);

        //Dependency injection without dagger
        /*PseudoAuthentication creation = new PseudoAuthentication();
        PseudoAuthentication signing = new PseudoAuthentication();
        AuthValidation authValidation = new AuthValidation(creation,signing);
        createAccount = new CreateAccountPresenter.CreateAccount(creation, authValidation);*/





    }
}
