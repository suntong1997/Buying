package com.example.buying.main.model;

import android.os.AsyncTask;

import com.example.buying.Util.HttpUtil;
import com.example.buying.main.bean.ResultData;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;

import okhttp3.Response;


public class AppAsyncTask extends AsyncTask<Void,Void, String> {
    private String adress;
    private ResultData resultData;//存储接收的数据

    public AppAsyncTask(String url) {
        this.adress = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(Void... voids) {
        HttpUtil.sendOKHttpRequest(adress,new okhttp3.Callback(){

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Gson gson=new Gson();
                String JSONResult=response.body().toString();//获取获取的数据
                resultData=gson.fromJson(JSONResult,ResultData.class);//将JSON数据转换成对象
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
        });
        return null;
    }

    public ResultData getResultData() {
        return resultData;
    }
}
