package com.higglerslab.framework.Login;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.JsonObject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by dinesh on 8/9/17.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private FirebaseAuth auth;
    private final LoginContract.View mLoginView;
    public LoginPresenter(@NonNull LoginContract.View tasksView) {
        // mTasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null");
        mLoginView = checkNotNull(tasksView, "tasksView cannot be null!");

        mLoginView.setPresenter(this);
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void start() {
//        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String password) {

    }


    @Override
    public void updateCredentials(JsonObject js) {

    }
}
