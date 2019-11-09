package com.example.buying.login;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.buying.login.fragment.LoginFragment;

import com.example.buying.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
   public static String getAccount=null;//存储注册时的账号便于登录界面接收
    public static ArrayList<UserAccount> arrayList=new ArrayList();//存储用户注册的账户，在RegisterFragment中调用，如果账户存在碎片的list中在点击注册后返回到上一个界面list里面内容会消失

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*关闭标题栏*/
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        getSupportFragmentManager().beginTransaction().add(R.id.login_activity_fragment,LoginFragment.newInstance()).addToBackStack(null).commit();//添加碎片到活动中
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
