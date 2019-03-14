package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.yogg_sogott.sunnetwork.domain.AuthValidation;
import com.example.yogg_sogott.sunnetwork.presentation.AuthValidationComponent;

@InjectViewState
public class CreateAccountPresenter extends MvpPresenter<CreateAccountView> {



    void onErrorCancel() {
        getViewState().hideError();
    }


        void crAccClicked (String login, String password, String repeat){
            //Dagger2
            AuthValidationComponent AVComponent = DaggerAuthValidationComponent.create();
            AuthValidation aV = AVComponent.getAuthValidation();

            //Setting fields so we can compare them
            aV.creationSetter(login, password, repeat);
        if (aV.checkIfPasswordsAreSame()) {
            getViewState().onSuccess("Success!");
            //Accessing PAuth obj and creating local account
            aV.getCreation().createAccount();
        } else getViewState().failedCreateAccount("Passwords don't match!");
    }





}
