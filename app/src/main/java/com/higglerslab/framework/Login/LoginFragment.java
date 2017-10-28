package com.higglerslab.framework.Login;

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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.higglerslab.framework.R;
import com.higglerslab.framework.register.RegisterActivity;
import com.higglerslab.framework.service.DataManager;
import com.irozon.sneaker.Sneaker;

import org.greenrobot.eventbus.EventBus;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by dinesh on 8/9/17.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    private LoginContract.Presenter mPresenter;
    private EditText username, pword;
    private Button btnSignIn, signupBtn;
    private EventBus event;
    private RelativeLayout loading;

    public LoginFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        loading = (RelativeLayout) getActivity().findViewById(R.id.loading);

        btnSignIn = (Button) root.findViewById(R.id.loginBtn);
        signupBtn = (Button) root.findViewById(R.id.signupBtn);

        username = (EditText) root.findViewById(R.id.username);
        pword = (EditText) root.findViewById(R.id.password);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });


        return root;
    }

    private void signup() {

        Intent intent = new Intent(getContext(), RegisterActivity.class);
        startActivityForResult(intent, 1);
        getActivity().finish();
        getActivity().overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
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
        // event.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        event.unregister(this);
    }
}
