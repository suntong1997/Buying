package com.example.buying.main.bean;

import java.util.ArrayList;

public class ResultData {
        int status;
        ArrayList<GoodsDetail> mList;

    public ResultData(int status, ArrayList<GoodsDetail> mList) {
        this.status = status;
        this.mList = mList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<GoodsDetail> getmList() {
        return mList;
    }

    public void setmList(ArrayList<GoodsDetail> mList) {
        this.mList = mList;
    }
}
