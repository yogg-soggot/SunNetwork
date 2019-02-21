package com.example.yogg_sogott.sunnetwork.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.yogg_sogott.sunnetwork.data.PseudoAuthentication;
import com.example.yogg_sogott.sunnetwork.domain.AuthValidation;

@InjectViewState
public class CreateAccountPresenter extends MvpPresenter<CreateAccountView> {



    void onErrorCancel() {
        getViewState().hideError();
    }


        void crAccClicked (String login, String password, String repeat){
        // PseudoAuthentication creation = new PseudoAuthentication();
        //AuthValidation authValidation = new AuthValidation(CreateAccount.getCreation(), null);
        CreateAccount
                .getAuthValidation()
                .creationSetter(login, password, repeat);
        if (CreateAccount
                .getAuthValidation()
                .checkIfPasswordsAreSame()) {
            getViewState()
                    .failedCreateAccount("Success!");
            CreateAccount
                    .getAuthValidation()
                    .getCreation()
                    .createAccount();
        } else getViewState()
                .failedCreateAccount("Passwords don't match!");
    }

    /* This class is needed to receive dependency outside presenter.
     * I used Pseudo Auth Init Manager to make new class object
     * looks like spaghetti, but now I know how to use dependency injection without dagger2
     */
    public static class CreateAccount{
        static PseudoAuthentication creation;
        static AuthValidation authValidation;

        public CreateAccount(PseudoAuthentication creation, AuthValidation authValidation) {
            this.creation = creation;
            this.authValidation = authValidation;
        }


        static AuthValidation getAuthValidation(){
            return authValidation;
        }

    }


}
