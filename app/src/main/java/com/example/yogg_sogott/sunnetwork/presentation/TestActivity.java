package com.example.yogg_sogott.sunnetwork.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpActivity;
import com.example.yogg_sogott.sunnetwork.R;
import com.example.yogg_sogott.sunnetwork.data.NetworkService;
import com.example.yogg_sogott.sunnetwork.data.PAuthInitManager;
import com.example.yogg_sogott.sunnetwork.data.PostDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;


//Bullshit code here
public class TestActivity extends MvpActivity {

    private Button mGetButton;
    private Button mPostButton;
    private EditText id;
    private EditText user;
    private EditText body;

    int intid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        mGetButton = findViewById(R.id.button_get);
        mPostButton = findViewById(R.id.button_post);
        id = findViewById(R.id.id);
        user = findViewById(R.id.user);
        body = findViewById(R.id.body);

        mGetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intid = Integer.parseInt(id.getText().toString());

                NetworkService.getInstance()
                        .getJSONApi()
                        .getPostWithID(intid)
                        .enqueue(new Callback<PostDTO>() {
                            @Override
                            public void onResponse(@NonNull Call<PostDTO> call,@NonNull Response<PostDTO> response) {


                                PostDTO post = response.body();


                                try {
                                    id.setText(Integer.toString(post.getId()));
                                    user.setText(post.getUserLogin());
                                    body.setText(post.getBody());
                                }
                                catch (NullPointerException e){
                                    Log.wtf("setting text","failed to set text");
                                }


                            }

                            @Override
                            public void onFailure(@NonNull Call<PostDTO> call, Throwable t) {
                                body.setText("Failure");
                            }
                        });
            }
        });

        mPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intid = Integer.parseInt(id.getText().toString());

                PostDTO postDTO = new PostDTO();
                postDTO.setBody(body.getText().toString());
                postDTO.setUserLogin(user.getText().toString());
                postDTO.setId(Integer.parseInt(id.getText().toString()));
                NetworkService.getInstance()
                        .getJSONApi()
                        .post(postDTO)
                        .enqueue(new Callback<PostDTO>() {
                            @Override
                            public void onResponse(@NonNull Call<PostDTO> call,@NonNull Response<PostDTO> response) {

                                Log.w("progress","Success");
                                Log.w("progress","Success");
                                Log.w("progress","Success");
                                Log.w("progress","Success");
                                Log.w("progress","Success");
                                Log.w("progress","Success");
                                Log.w("progress","Success");
                                Log.w("progress","Success");



                            }

                            @Override
                            public void onFailure(@NonNull Call<PostDTO> call, Throwable t) {
                                Log.w("progress","Failure");
                                Log.w("progress","Failure");
                                Log.w("progress","Failure");
                                Log.w("progress","Failure");
                                Log.w("progress","Failure");
                                Log.w("progress","Failure");
                                Log.w("progress","Failure");
                                Log.w("progress","Failure");


                            }
                        });
            }
        });
    }

}
