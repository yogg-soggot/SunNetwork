package com.example.yogg_sogott.sunnetwork.presentation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;


//import butterknife.BindView;
//import butterknife.ButterKnife;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class LoginActivity extends MvpActivity implements LoginView {

    @InjectPresenter
    LoginPresenter mLoginPresenter;


    private Button mLoginButton;
    private Button mCreateAccountButton;
    private EditText mLoginText;
    private EditText mPasswordText;

    private AlertDialog mErrorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        mLoginButton =  findViewById(R.id.log_in);
        mCreateAccountButton = findViewById(R.id.create);
        mLoginText = findViewById(R.id.login);
        mPasswordText = findViewById(R.id.password);


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.onLoginClicked(mLoginText.getText().toString(),
                                               mPasswordText.getText().toString());

            }
        });

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void failedSignIn(final String message) {
        Log.e("Sign In",message);
        mErrorDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(message)
                .show();
        mErrorDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                mLoginPresenter.onErrorCancel();
            }
        });
    }

    @Override
    public void hideError() {
        if (mErrorDialog != null && mErrorDialog.isShowing()) {
            mErrorDialog.cancel();
        }
    }
    @Override
    public void gotoTest() {
        Intent intent = new Intent(getApplicationContext(),TestActivity.class);
        startActivity(intent);
    }

    @Override
    public void gotoFeed() {
        Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
        startActivity(intent);
    }
}





