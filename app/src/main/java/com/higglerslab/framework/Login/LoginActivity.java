package com.higglerslab.framework.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.higglerslab.framework.R;
import com.higglerslab.framework.util.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (loginFragment == null) {
            loginFragment = loginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),loginFragment,R.id.contentFrame);
        }

       new LoginPresenter(loginFragment);
    }
}
