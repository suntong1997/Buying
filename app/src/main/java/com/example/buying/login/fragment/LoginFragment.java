package com.example.buying.login.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buying.R;
import com.example.buying.login.LoginActivity;
import com.example.buying.login.UserAccount;
import com.example.buying.main.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    TextView registerTv;
    Button loginBtn;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private EditText accEdt;
    private EditText pwdEdt;
    private ArrayList<UserAccount> list;
    private Gson gson;
    UserAccount userAccount;
    private String getAccount;
    private String getPwd;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        pwdEdt.setText("");
        accEdt.setText("");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (LoginActivity.getAccount!=null){
            accEdt.setText(LoginActivity.getAccount);
            LoginActivity.getAccount=null;
        }
    }

    //初始化数据
    private void initData() {
        pref = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        editor = pref.edit();
        list = new ArrayList<>();
        gson = new Gson();
        userAccount = new UserAccount();
    }

    //初始化界面
    private void initView(View view) {
        registerTv = view.findViewById(R.id.register_text);
        loginBtn = view.findViewById(R.id.login_button);
        accEdt = view.findViewById(R.id.login_account);
        pwdEdt = view.findViewById(R.id.login_password);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        registerTv.setOnClickListener((view) -> {
            getFragmentManager().beginTransaction().replace(R.id.login_activity_fragment, RegisterFragment.newInstance()).addToBackStack(null).commit();
        });

        /*点击按钮登录账户*/
        loginBtn.setOnClickListener((view) -> {

            String user = pref.getString("user", null);
            list = gson.fromJson(user, new TypeToken<ArrayList<UserAccount>>() {
            }.getType());

            /*遍历寻找用户账号是否存在且密码正确*/
            if (list != null) {
                for (UserAccount userAccount : list) {

                    if (accEdt.getText().toString().equals(userAccount.getAccount()) && pwdEdt.getText().toString().equals(userAccount.getPassword())) {    //判断用户账号和密码是否匹配，若匹配则跳转到主界面并销毁登录界面
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getContext(), "密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(getContext(), "请先注册一个账户", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
