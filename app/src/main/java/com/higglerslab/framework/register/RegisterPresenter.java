package com.higglerslab.framework.register;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.JsonObject;
import com.higglerslab.framework.service.remote.ProfileAPI;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by work on 18/9/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter{

    private FirebaseAuth auth;
    private final RegisterContract.View mRegisterView;

    private ProfileAPI sProfileApi = new ProfileAPI();

    public RegisterPresenter(@NonNull RegisterContract.View tasksView) {
        // mTasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null");
        mRegisterView = checkNotNull(tasksView, "tasksView cannot be null!");

        mRegisterView.setPresenter(this);
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

    @Override
    public void createProfile() {
        sProfileApi.createProfile();
    }
}
