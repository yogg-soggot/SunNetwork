package com.example.yogg_sogott.sunnetwork.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.yogg_sogott.sunnetwork.data.PseudoAuthentication;
import com.example.yogg_sogott.sunnetwork.domain.AuthValidation;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {



    public void onErrorCancel() {
        getViewState().hideError();
    }

    void onLoginClicked(String login, String password){
        PseudoAuthentication signing = new PseudoAuthentication();
        AuthValidation authValidation = new AuthValidation(null,signing);
        signing.setLogin(login);
        signing.setPassword(password);
        signing.auth();
        if (authValidation.checkPassword()){
            getViewState().failedSignIn("Success!");
        } else getViewState().failedSignIn("Password is wrong!");
    }






}
