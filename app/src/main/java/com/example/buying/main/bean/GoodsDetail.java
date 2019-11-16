package com.example.buying.main.bean;

import android.widget.ImageView;
import android.widget.TextView;

public class GoodsDetail {
    ImageView goodsImage;
    TextView goodsName;
    TextView gooodsDesc;
    TextView goodsPrice;
    TextView goodsAction;
    TextView goodsSold;

    public GoodsDetail(ImageView goodsImage, TextView goodsName, TextView gooodsDesc, TextView goodsPrice, TextView goodsAction, TextView goodsSold) {
        this.goodsImage = goodsImage;
        this.goodsName = goodsName;
        this.gooodsDesc = gooodsDesc;
        this.goodsPrice = goodsPrice;
        this.goodsAction = goodsAction;
        this.goodsSold = goodsSold;
    }

    public ImageView getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(ImageView goodsImage) {
        this.goodsImage = goodsImage;
    }

    public TextView getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(TextView goodsName) {
        this.goodsName = goodsName;
    }

    public TextView getGooodsDesc() {
        return gooodsDesc;
    }

    public void setGooodsDesc(TextView gooodsDesc) {
        this.gooodsDesc = gooodsDesc;
    }

    public TextView getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(TextView goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public TextView getGoodsAction() {
        return goodsAction;
    }

    public void setGoodsAction(TextView goodsAction) {
        this.goodsAction = goodsAction;
    }

    public TextView getGoodsSold() {
        return goodsSold;
    }

    public void setGoodsSold(TextView goodsSold) {
        this.goodsSold = goodsSold;
    }
}
