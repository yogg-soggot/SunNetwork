package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class CreateAccountPresenter extends MvpPresenter<CreateAccountView> {


    public void onErrorCancel() {
        getViewState().hideError();
    }
}
