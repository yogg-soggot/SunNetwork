package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.yogg_sogott.sunnetwork.data.CommentDTO;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface CommentsView extends MvpView {
    void showComments(List<CommentDTO> data);

    @StateStrategyType(SingleStateStrategy.class)
    void hideProgressBar();
}
