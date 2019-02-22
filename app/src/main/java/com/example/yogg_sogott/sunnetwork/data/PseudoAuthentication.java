package com.example.yogg_sogott.sunnetwork.data;









import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import javax.inject.Inject;


public class PseudoAuthentication {

    @Inject
    public PseudoAuthentication(){}

    private String login;
    private String password;
    private String true_password;

    private static SharedPreferences sharedPref;
    private final static String CONFIRMED_LOGIN_KEY = "This key is needed to get login after auth is done";


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }


    public String getTrue_password() {
        return true_password;
    }


    public void setPassword(String password) {
        this.password = password;

    }

    static void init(Context context){
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context);


    }

    public String getConfirmedLogin(){
        return sharedPref.getString(CONFIRMED_LOGIN_KEY,"Anonymous");
    }

    public void setConfirmedLogin(String login){
        sharedPref.edit().putString(CONFIRMED_LOGIN_KEY,login).apply();
    }




    public void createAccount(){
       sharedPref.edit().putString(login,password).apply();


    }


    public void auth() {
       this.true_password = sharedPref.getString(login, null);




   }

}
