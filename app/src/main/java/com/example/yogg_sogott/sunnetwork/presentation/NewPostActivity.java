package com.example.yogg_sogott.sunnetwork.presentation;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;


public class NewPostActivity extends MvpActivity implements NewPostView {
    @InjectPresenter
    NewPostPresenter newPostPresenter;

    private Button addButton;
    private TextView postText;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_new_post);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        addButton = findViewById(R.id.add_post);
        postText = findViewById(R.id.new_post_text);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newPostPresenter.onAddPostClicked();
            }
        });
    }

    @Override
    public void gotoFeed(){
        Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
        intent.putExtra("Text",postText.getText().toString());
        startActivity(intent);
    }


}
