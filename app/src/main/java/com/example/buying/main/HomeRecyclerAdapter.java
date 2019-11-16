package com.example.buying.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buying.R;
import com.example.buying.main.bean.GoodsDetail;

import java.util.ArrayList;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder> {
    ArrayList<GoodsDetail> mList = new ArrayList<>();
    Context mContext;

    void HomeRecyclerAdapter(ArrayList<GoodsDetail> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.home_recycler_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.goodsImage = mList.get(position).getGoodsImage();
        holder.goodsName = mList.get(position).getGoodsName();
        holder.gooodsDesc = mList.get(position).getGooodsDesc();
        holder.goodsPrice = mList.get(position).getGoodsPrice();
        holder.goodsAction = mList.get(position).getGoodsAction();
        holder.goodsSold = mList.get(position).getGoodsSold();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView goodsImage;
        TextView goodsName;
        TextView gooodsDesc;
        TextView goodsPrice;
        TextView goodsAction;
        TextView goodsSold;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            goodsImage = itemView.findViewById(R.id.goods_image);
            goodsName = itemView.findViewById(R.id.goods_name);
            gooodsDesc = itemView.findViewById(R.id.goods_desc);
            goodsPrice = itemView.findViewById(R.id.goods_price);
            goodsAction = itemView.findViewById(R.id.goods_action);
            goodsSold = itemView.findViewById(R.id.goods_sold);
        }
    }
}
