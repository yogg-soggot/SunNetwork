package com.example.yogg_sogott.sunnetwork.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.yogg_sogott.sunnetwork.domain.AuthValidation;


@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {



    public void onErrorCancel() {
        getViewState().hideError();
    }

    void onLoginClicked(String login, String password){

        //Dagger2
        AuthValidationComponent AVComponent = DaggerAuthValidationComponent.create();
        AuthValidation aV = AVComponent.getAuthValidation();

        aV.creationSetter(login,password);
        aV.getSigning().auth();
        if (aV.checkPassword()){
           // getViewState().failedSignIn("Success!");
            getViewState().gotoFeed();
        } else getViewState().failedSignIn("Password is wrong!");
    }






}
