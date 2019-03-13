package com.example.yogg_sogott.sunnetwork.presentation;


import com.example.yogg_sogott.sunnetwork.domain.AuthValidation;

import dagger.Component;
//This should be in domain folder, but i'm 2 lazy 2 move it
@Component
public interface AuthValidationComponent {
    AuthValidation getAuthValidation();
}
