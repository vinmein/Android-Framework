package com.higglerslab.framework.Login;

import com.google.gson.JsonObject;
import com.higglerslab.framework.BaseView;

/**
 * Created by dinesh on 8/9/17.
 */

public interface LoginContract  {

    interface View extends BaseView<Presenter>{

        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BaseView {

        void start();

        void login(String email, String password);

        void updateCredentials(JsonObject js);
    }
}
