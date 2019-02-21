package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface CreateAccountView extends MvpView {

    void failedCreateAccount(String message);

    void hideError();

}
