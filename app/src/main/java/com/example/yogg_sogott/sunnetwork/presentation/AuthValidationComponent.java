package com.example.yogg_sogott.sunnetwork.presentation;


import com.example.yogg_sogott.sunnetwork.domain.AuthValidation;

import dagger.Component;

@Component
public interface AuthValidationComponent {
    AuthValidation getAuthValidation();
}
