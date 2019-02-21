package com.example.yogg_sogott.sunnetwork.domain;



import com.example.yogg_sogott.sunnetwork.data.PseudoAuthentication;

//Dependency injection without dagger
public class AuthValidation {
    private PseudoAuthentication creation;
    private PseudoAuthentication signing;

    private String repeat;

    public AuthValidation(PseudoAuthentication creation, PseudoAuthentication signing){
        this.creation = creation;
        this.signing = signing;

    }

    public void setRepeat(String repeat){
        this.repeat = repeat;
    }

    public PseudoAuthentication getCreation(){
        return creation;
    }

    public void creationSetter(String login, String password, String repeat){
        creation.setLogin(login);
        creation.setPassword(password);
        this.repeat = repeat;

    }


    public boolean checkIfPasswordsAreSame(){
        return (creation.getPassword().equals(repeat));
    }
    public boolean checkPassword(){
        return (signing.getPassword().equals(signing.getTrue_password()));
    }



}
