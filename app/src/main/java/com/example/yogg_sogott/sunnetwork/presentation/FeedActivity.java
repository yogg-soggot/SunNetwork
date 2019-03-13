package com.example.yogg_sogott.sunnetwork.presentation;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;
import com.example.yogg_sogott.sunnetwork.data.PostDTO;

import java.util.List;

public class FeedActivity extends MvpActivity implements FeedView {

    @InjectPresenter
    FeedPresenter mFeedPresenter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_feed);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mFeedPresenter.getData();




    }


    @Override
    public void showPosts(List<PostDTO> data) {
        mAdapter = new MyAdapter(data);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgressBar(){

        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void gotoComments(){
        Intent intent = new Intent(getApplicationContext(),CommentsActivity.class);
        startActivity(intent);
    }
}
