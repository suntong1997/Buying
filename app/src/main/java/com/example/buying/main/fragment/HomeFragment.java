package com.example.buying.main.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buying.R;
import com.example.buying.main.Adapter.HomeRecyclerAdapter;
import com.example.buying.main.bean.GoodsDetail;
import com.example.buying.main.model.AppAsyncTask;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    String dataUrl="http://www.imooc.com/api/shopping?type=11";

    ArrayList<GoodsDetail> mList;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(){
        HomeFragment homeFragment =new HomeFragment();
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());

        AppAsyncTask asyncTask= (AppAsyncTask) new AppAsyncTask(dataUrl).execute();//获取接收的数据

        mList=asyncTask.getResultData().getmList();//存储item列表数据

        recyclerView.setLayoutManager(manager);
        HomeRecyclerAdapter adapter=new HomeRecyclerAdapter(mList,getContext());
        recyclerView.setAdapter(adapter);

    }
}
