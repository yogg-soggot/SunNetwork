package com.example.yogg_sogott.sunnetwork.Presentation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class LoginActivity extends MvpActivity implements LoginView {

    @InjectPresenter
    LoginPresenter mLoginpresenter;

    private Button mLoginButton;
    private Button mCreateAccountButton;

    private EditText mLoginText;
    private EditText mPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        mLoginButton =  findViewById(R.id.log_in);
        mCreateAccountButton = findViewById(R.id.create);
        mLoginText = findViewById(R.id.login);
        mPasswordText = findViewById(R.id.password);
    }


}
