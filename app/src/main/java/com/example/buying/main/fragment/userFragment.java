package com.example.buying.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.buying.R;


public class userFragment extends Fragment {


    public userFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static userFragment newInstance(String param1, String param2) {
        userFragment fragment = new userFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_user, container, false);
        return view;
    }


}
