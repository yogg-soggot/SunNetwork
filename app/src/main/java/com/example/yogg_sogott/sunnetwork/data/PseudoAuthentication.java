package com.example.yogg_sogott.sunnetwork.data;








import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;


public class PseudoAuthentication extends Fragment {
    private String login;
    private String password;
    private String true_password;

    @NonNull
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @NonNull
    public String getTrue_password() {
        return true_password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void createAccount(){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(login,password);
        editor.apply();
    }

    public void auth(){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        this.true_password = sharedPref.getString(login,null);
    }

}
