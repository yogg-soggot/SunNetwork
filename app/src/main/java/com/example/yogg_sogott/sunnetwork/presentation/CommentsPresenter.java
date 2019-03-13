package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.yogg_sogott.sunnetwork.data.CommentDTO;
import com.example.yogg_sogott.sunnetwork.data.DaggerNetworkServiceComponent;
import com.example.yogg_sogott.sunnetwork.data.NetworkService;
import com.example.yogg_sogott.sunnetwork.data.NetworkServiceComponent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

@InjectViewState
public class CommentsPresenter extends MvpPresenter<CommentsView> {
    void getData(int id){

        //Dagger2
        NetworkServiceComponent NSComponent = DaggerNetworkServiceComponent.create();
        NetworkService networkService = NSComponent.getNetworkService();

        networkService
                .getJSONApi()
                .getCommentWithPostId(id)
                .enqueue(new Callback<List<CommentDTO>>() {
                    @EverythingIsNonNull
                    @Override
                    public void onResponse(Call<List<CommentDTO>> call, Response<List<CommentDTO>> response) {
                        getViewState().hideProgressBar();
                        getViewState().showComments(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<CommentDTO>> call, Throwable t) {
                        getViewState().hideProgressBar();

                    }
                });

    }


}
