package com.example.yogg_sogott.sunnetwork.presentation;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;
import com.example.yogg_sogott.sunnetwork.data.PostDTO;
import com.example.yogg_sogott.sunnetwork.data.PseudoAuthentication;

import java.util.List;

public class FeedActivity extends MvpActivity implements FeedView {

    @InjectPresenter
    FeedPresenter mFeedPresenter;

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private ImageView newpost;
    private String newPostText;
    private String userLogin;
    private PostDTO newPost;
    private TextView text;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_feed);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        progressBar = findViewById(R.id.progressBar);
        newpost = findViewById(R.id.new_post);
        text = findViewById(R.id.add);


        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);


        mFeedPresenter.getData();



        newpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNewPost();
            }
        });



    }




    @Override
    public void getNewPost() {
        newPostText = text.getText().toString();
        userLogin = PseudoAuthentication.getConfirmedLogin();
        newPost = new PostDTO();
        newPost.setUserLogin(userLogin);
        newPost.setBody(newPostText);
        mAdapter.addPost(newPost);
        mAdapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
        text.setText("");



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
