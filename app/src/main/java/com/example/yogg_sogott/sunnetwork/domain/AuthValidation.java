package com.example.yogg_sogott.sunnetwork.domain;



import com.example.yogg_sogott.sunnetwork.data.PseudoAuthentication;

import javax.inject.Inject;

//Business logic here
public class AuthValidation {
    //This obj is used to create local acc
    private PseudoAuthentication creation;
    //This is used to sign in
    private PseudoAuthentication signing;

    //Repeat password -> check if passwords are same
    private String repeat;

    @Inject
    public AuthValidation(PseudoAuthentication creation, PseudoAuthentication signing){
        this.creation = creation;
        this.signing = signing;

    }



    public PseudoAuthentication getCreation(){
        return creation;
    }
    public PseudoAuthentication getSigning(){return signing;}

    public void creationSetter(String login, String password, String repeat){
        creation.setLogin(login);
        creation.setPassword(password);
        this.repeat = repeat;

    }

    public void creationSetter(String login, String password){
        signing.setLogin(login);
        signing.setPassword(password);
    }


    public boolean checkIfPasswordsAreSame(){
        return (creation.getPassword().equals(repeat));
    }
    public boolean checkPassword(){
        return (signing.getPassword().equals(signing.getTrue_password()));
    }



}
