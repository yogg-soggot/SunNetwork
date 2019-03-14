package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.yogg_sogott.sunnetwork.data.PostDTO;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface FeedView extends MvpView {

    void showPosts(List<PostDTO> data);

    @StateStrategyType(SingleStateStrategy.class)
    void hideProgressBar();

    @StateStrategyType(SingleStateStrategy.class)
    void gotoComments();

    void getNewPost();

}
