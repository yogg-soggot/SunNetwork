package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface LoginView extends MvpView {

    void failedSignIn(String message);
    void hideError();
    void gotoFeed();
}
