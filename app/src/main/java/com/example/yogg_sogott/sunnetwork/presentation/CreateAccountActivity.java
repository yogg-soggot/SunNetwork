package com.example.yogg_sogott.sunnetwork.presentation;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.yogg_sogott.sunnetwork.R;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class CreateAccountActivity extends MvpActivity implements CreateAccountView {

    @InjectPresenter
    CreateAccountPresenter mCreateAccountPresenter;

    private Button mCreateAccountButton;

    private EditText mLoginText;
    private EditText mPasswordText;
    private EditText mPasswordText2;

    private AlertDialog mErrorDialog;

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

    @Override
    public void failedCreateAccount(String message) {
        mErrorDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(message)
                .show();
        mErrorDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                mCreateAccountPresenter.onErrorCancel();
            }
        });
    }

    @Override
    public void hideError() {
        if (mErrorDialog != null && mErrorDialog.isShowing()) {
            mErrorDialog.cancel();
        }
    }
}
