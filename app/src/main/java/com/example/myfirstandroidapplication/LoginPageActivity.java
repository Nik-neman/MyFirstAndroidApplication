package com.example.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class LoginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void FragmentChange(View v){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (v.getId()){
            case R.id.fr1:
                InfoFragment info_Fragment = new InfoFragment();
                ft.replace(R.id.fragment, info_Fragment);
                break;

            case R.id.fr2:
                SecondFragment second_Fragment = new SecondFragment();
                ft.replace(R.id.fragment, second_Fragment);
                break;

        }
        ft.commit();
    }
}