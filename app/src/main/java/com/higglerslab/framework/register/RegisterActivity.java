package com.higglerslab.framework.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.higglerslab.framework.R;
import com.higglerslab.framework.util.ActivityUtils;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, pword;
    private Button btnSignIn, signupBtn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterFragment registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (registerFragment == null) {
            registerFragment = registerFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),registerFragment,R.id.contentFrame);
        }

        new RegisterPresenter(registerFragment);


    }
}
