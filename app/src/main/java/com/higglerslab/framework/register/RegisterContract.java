package com.higglerslab.framework.register;

import com.google.gson.JsonObject;
import com.higglerslab.framework.BaseView;

/**
 * Created by work on 18/9/17.
 */

public interface RegisterContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BaseView {

        void start();

        void login(String email, String password);

        void updateCredentials(JsonObject js);

        void createProfile();
    }
}
