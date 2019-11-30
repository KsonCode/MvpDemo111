package com.bwie.okhttpdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bwie.okhttpdemo.R;
import com.bwie.okhttpdemo.entity.ProductEntity;

import java.io.PipedReader;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<ProductEntity.Product> list;

    public ProductAdapter(Context context, List<ProductEntity.Product> list) {
        this.context = context;
        this.list = list;

    }

    /**
     * viewholder的初始化
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 展示数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //标题展示
        holder.tv.setText(list.get(position).commodityName);

        //图片展示
        Glide.with(context).load(list.get(position).masterPic).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_product);
            tv = itemView.findViewById(R.id.tv_title);
        }
    }
}
