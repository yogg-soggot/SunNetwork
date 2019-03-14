package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface NewPostView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void gotoFeed();
}
