package com.higglerslab.framework.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.ahamed.multiviewadapter.SimpleRecyclerAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.higglerslab.framework.R;
import com.higglerslab.framework.service.DataManager;
import com.higglerslab.framework.service.events.ErrorEvent;
import com.higglerslab.framework.service.events.createPackageSuccessEvent;
import com.higglerslab.framework.service.events.getPackageSuccessEvent;
import com.higglerslab.framework.service.events.getProfileSuccessEvent;
import com.irozon.sneaker.Sneaker;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by work on 8/9/17.
 */

public class DashboardFragment extends Fragment implements DashboardContract.View {

    private DashboardContract.Presenter mPresenter;
    private EventBus event;
    private EditText package_name;
    private Button createPackage;
    private ImageButton scanner, menu;

    private InterstitialAd mInterstitialAd;
    private RelativeLayout loading;
    private RecyclerView recycle;


    public DashboardFragment() {

    }

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public void setPresenter(DashboardContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if(active){
            loading.setVisibility(View.VISIBLE);
        }
        else{
            loading.setVisibility(View.GONE);
        }
    }





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        package_name = (EditText) root.findViewById(R.id.package_name);
        createPackage = (Button) root.findViewById(R.id.createPackage);
        scanner = (ImageButton) root.findViewById(R.id.scanner);
        loading = (RelativeLayout) getActivity().findViewById(R.id.loading);
        menu = (ImageButton) root.findViewById(R.id.menu);


        return root;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterstitialAd = new InterstitialAd(getActivity().getApplicationContext());
//        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdUnitId("ca-app-pub-3015424658687473/6183048754");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        event = EventBus.getDefault();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();

    }

    @Override
    public void onStart() {
        super.onStart();
       // event.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        event.unregister(this);
    }


}
