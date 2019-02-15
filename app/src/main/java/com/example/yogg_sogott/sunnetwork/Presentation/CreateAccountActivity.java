package com.example.yogg_sogott.sunnetwork.Presentation;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class CreateAccountActivity extends MvpActivity implements LoginView {

    @InjectPresenter
    LoginPresenter mLoginpresenter;

    private Button mCreateAccountButton;

    private EditText mLoginText;
    private EditText mPasswordText;
    private EditText mPasswordText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        mCreateAccountButton = findViewById(R.id.create_create);
        mLoginText = findViewById(R.id.login_c);
        mPasswordText = findViewById(R.id.password_c);
        mPasswordText2 = findViewById(R.id.password_2);
    }
}
