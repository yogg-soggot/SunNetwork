package com.example.yogg_sogott.sunnetwork.Presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    public void signIn(String login, String password){
    }

    public void onErrorCancel() {
        getViewState().hideError();
    }






}
