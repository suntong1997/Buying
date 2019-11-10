package com.example.buying.main;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.buying.R;
import com.example.buying.login.fragment.LoginFragment;
import com.example.buying.main.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*关闭标题栏*/
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.main_fragment, HomeFragment.newInstance()).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //当栈中没有碎片时退出app
        if (getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        }
    }
}
