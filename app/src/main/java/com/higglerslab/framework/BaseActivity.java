package com.higglerslab.framework;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.higglerslab.framework.Login.LoginActivity;


/**
 * Created by dinesh on 7/7/17.
 */

public class BaseActivity extends AppCompatActivity {

    NavigationView navigationView;
    public void loadUserDetails(){
       // navigationView = (NavigationView) findViewById(R.id.nav_view);
        View navHeader = navigationView.getHeaderView(0);
//        TextView pName=(TextView)navHeader.findViewById(R.id.username);
//        TextView pEmail=(TextView)navHeader.findViewById(R.id.email);

    }

    public void navigate(int id, Activity from, String Activity){

    }

    public void loadLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, 1);
    }

    public void loadUserInfo(){

    }
}
