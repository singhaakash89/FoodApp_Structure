package com.food_app.component.registration.admin;

import com.food_app.component.registration.SignUp;

/**
 * Created by Aakash Singh on 24-10-2016.
 */
public class StandardAdminSignUp implements SignUp {
    @Override
    public boolean register() {
        return false;
    }

    @Override
    public boolean isRegistrationSuccessful() {
        return false;
    }

    @Override
    public boolean isAlreadyRegistered() {
        return false;
    }

    @Override
    public boolean unRegister() {
        return false;
    }
}
