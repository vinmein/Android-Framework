package com.higglerslab.framework.dashboard;

import android.Manifest;
import android.os.Bundle;

import com.higglerslab.framework.BaseActivity;
import com.higglerslab.framework.R;
import com.higglerslab.framework.service.DataManager;
import com.higglerslab.framework.util.ActivityUtils;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class DashboardActivity extends BaseActivity {
    private DashboardPresenter  mDashBoardPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        DashboardFragment dashboardFragment = (DashboardFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (dashboardFragment == null) {
            dashboardFragment = dashboardFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),dashboardFragment,R.id.contentFrame);
        }

        mDashBoardPresenter = new DashboardPresenter(dashboardFragment);

        if (DataManager.getUserToken() == null || DataManager.getUserToken() == "") {
            loadLogin();
        }

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.MEDIA_CONTENT_CONTROL,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();


    }


}
