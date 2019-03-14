package com.example.yogg_sogott.sunnetwork.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


@InjectViewState
public class NewPostPresenter extends MvpPresenter<NewPostView> {
    void onAddPostClicked(){
        getViewState().gotoFeed();
    }
}
