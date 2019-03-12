package com.example.yogg_sogott.sunnetwork.presentation;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.yogg_sogott.sunnetwork.data.NetworkService;
import com.example.yogg_sogott.sunnetwork.data.PostDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

@InjectViewState
public class FeedPresenter extends MvpPresenter<FeedView> {
    void getData(){
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<PostDTO>>() {
                    @Override
                    @EverythingIsNonNull
                    public void onResponse(Call<List<PostDTO>> call, Response<List<PostDTO>> response) {
                        getViewState().showPosts(response.body());
                    }

                    @Override
                    @EverythingIsNonNull
                    public void onFailure(Call<List<PostDTO>> call, Throwable t) {

                    }
                });
    }
}