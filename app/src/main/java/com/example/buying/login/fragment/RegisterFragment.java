package com.example.buying.login.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buying.R;
import com.example.buying.login.LoginActivity;
import com.example.buying.login.UserAccount;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private static final String TAG = "getContext()";
    private EditText accEdt;
    private EditText pwdEdt;
    private Button registerBtn;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private ArrayList<UserAccount> mList;

    private UserAccount userAccount;

    boolean isExist = false;
    Gson gson;

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {

        RegisterFragment registerFragment = new RegisterFragment();
        return registerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /* 点击按钮注册账号*/
        registerBtn.setOnClickListener((view) -> {

            String users = pref.getString("user", null);
            mList = gson.fromJson(users, new TypeToken<ArrayList<UserAccount>>() {
            }.getType());
            if (mList != null) {                   //判断是否有账号存在
                for (UserAccount aUser : mList) {
                    if (accEdt.getText().toString().equals(aUser.getAccount())) {    //判断用户账号是否存在
                        isExist = true;
                    }
                }
            }

            if (isExist) {
                Toast.makeText(getContext(), "账户已存在，请重新输入", Toast.LENGTH_SHORT).show();
                accEdt.setText("");
                pwdEdt.setText("");
                isExist = false;//重置账号存在标记
            } else {
                userAccount.setAccount(accEdt.getText().toString());
                userAccount.setPassword(pwdEdt.getText().toString());

                //防止返回登录碎片后数据丢失，将账户信息保存在活动的list中
                LoginActivity.arrayList.add(userAccount);

                String user = gson.toJson(LoginActivity.arrayList);

                editor.putString("user", user);
                editor.commit();
               // isExist = false;//重置账号存在标记
                LoginActivity.getAccount = accEdt.getText().toString();
                getFragmentManager().popBackStack();//注册完成后回到登录碎片
            }
        });
    }

    //初始化界面
    public void initView(View view) {
        accEdt = view.findViewById(R.id.register_account);
        pwdEdt = view.findViewById(R.id.register_password);
        registerBtn = view.findViewById(R.id.register_button);
    }

    //初始化数据
    private void initData() {
        pref = getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        editor = pref.edit();
        gson = new Gson();
        mList = new ArrayList<>();
        userAccount = new UserAccount();
    }
}
