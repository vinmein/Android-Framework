package com.higglerslab.framework.dashboard;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.higglerslab.framework.BaseView;

import java.util.ArrayList;

/**
 * Created by work on 8/9/17.
 */

public interface DashboardContract  {

    interface View extends BaseView<Presenter>{

        void setLoadingIndicator(boolean active);
    }

    interface Presenter extends BaseView {

        void start();
    }
}
