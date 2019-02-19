package com.example.yogg_sogott.sunnetwork.data;









import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;



public class PseudoAuthentication {
    private String login;
    private String password;
    private String true_password = "def";

    private static SharedPreferences sharedPref;

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

    static void init(Context context){
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context);


    }





    public void createAccount(){
       sharedPref.edit().putString(login,password).apply();


    }

   public void auth() {
       this.true_password = sharedPref.getString(login, "1");




   }

}
