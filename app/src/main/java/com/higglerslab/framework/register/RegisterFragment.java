package com.higglerslab.framework.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.higglerslab.framework.R;
import com.higglerslab.framework.dashboard.DashboardActivity;
import com.higglerslab.framework.Login.LoginActivity;
import com.higglerslab.framework.service.DataManager;
import com.higglerslab.framework.service.events.createProfileSuccessEvent;
import com.irozon.sneaker.Sneaker;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by work on 18/9/17.
 */

public class RegisterFragment extends Fragment implements RegisterContract.View {

    private RegisterContract.Presenter mPresenter;
    private EditText eMail, pword, retypePassword;
    private Button btnSignIn, signupBtn;
    private EventBus event;
    private RelativeLayout loading;

    public RegisterFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);

        loading = (RelativeLayout) getActivity().findViewById(R.id.loading);

        btnSignIn = (Button) root.findViewById(R.id.loginBtn);
        signupBtn = (Button) root.findViewById(R.id.signupBtn);

        eMail = (EditText) root.findViewById(R.id.email);
        pword = (EditText) root.findViewById(R.id.password);
        retypePassword = (EditText) root.findViewById(R.id.retypepassword);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        return root;
    }

    private void login() {

        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivityForResult(intent, 1);
        getActivity().finish();
        getActivity().overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }


    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            loading.setVisibility(View.VISIBLE);
        } else {
            loading.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = EventBus.getDefault();
    }

    @Override
    public void onResume() {
        super.onResume();
        setLoadingIndicator(false);
        mPresenter.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        setLoadingIndicator(false);
        //event.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        event.unregister(this);
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Subscribe
    public void onSuccess(createProfileSuccessEvent event) {
        Log.i("createPackage", String.valueOf(event));
        startActivity(new Intent(getActivity().getApplicationContext(), DashboardActivity.class));
        getActivity().finish();
    }
}
