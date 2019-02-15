package com.example.yogg_sogott.sunnetwork.Presentation;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class LoginActivity extends MvpActivity implements LoginView {

    @InjectPresenter
    LoginPresenter mLoginPresenter;

    @BindView (R.id.log_in) Button mLoginButton;
    @BindView (R.id.create) Button mCreateAccountButton;

    @BindView (R.id.login) EditText mLoginText;
    @BindView (R.id.password) EditText mPasswordText;

    private AlertDialog mErrorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        /*mLoginButton =  findViewById(R.id.log_in);
        mCreateAccountButton = findViewById(R.id.create);
        mLoginText = findViewById(R.id.login);
        mPasswordText = findViewById(R.id.password);*/
        ButterKnife.bind(this);

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void failedSignIn(String message) {
        mErrorDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(message)
                .setOnCancelListener(dialog -> mLoginPresenter.onErrorCancel())
                .show();


}
