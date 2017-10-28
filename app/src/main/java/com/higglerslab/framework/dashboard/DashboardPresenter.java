package com.higglerslab.framework.dashboard;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.higglerslab.framework.service.DataManager;
import com.higglerslab.framework.service.remote.PackageAPI;
import com.higglerslab.framework.service.remote.ProfileAPI;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by work on 8/9/17.
 */

public class DashboardPresenter implements DashboardContract.Presenter {

    private DashboardContract.View mDashboarView;

    private PackageAPI sPackageApi = new PackageAPI();

    private ProfileAPI sProfileApi = new ProfileAPI();

    private int currentPackage = 0;
    private int maxPackageCount = 5;
    private Boolean removeAds = false;
    private Boolean subscription = false;

    @Override
    public void setPresenter(Object presenter) {

    }

    public DashboardPresenter(@NonNull DashboardContract.View tasksView) {
        // mTasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null");
        mDashboarView = checkNotNull(tasksView, "tasksView cannot be null!");

        mDashboarView.setPresenter(this);
    }

    @Override
    public void start() {

    }


}
