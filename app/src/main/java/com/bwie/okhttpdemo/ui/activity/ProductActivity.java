package com.bwie.okhttpdemo.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwie.okhttpdemo.R;
import com.bwie.okhttpdemo.adapter.ProductAdapter;
import com.bwie.okhttpdemo.api.Api;
import com.bwie.okhttpdemo.base.BaseActivity;
import com.bwie.okhttpdemo.entity.ProductEntity;
import com.bwie.okhttpdemo.presenter.ProductPresenter;
import com.bwie.okhttpdemo.view.IProductView;
import com.google.gson.Gson;

import java.util.HashMap;

public class ProductActivity extends BaseActivity implements IProductView {


    private RecyclerView mProductRv;
    private ProductPresenter productPresenter;



    /**
     * 初始化数据
     */
    protected void initData() {

        productPresenter = new ProductPresenter(this);

        //请求参数
//        HashMap<String,String> params = new HashMap<>();
//        params.put("keyword","手机");
//        params.put("count","5");
//        params.put("page","1");
        String url = Api.PRODUCT_URL+"?keyword=1&count=5&page=1";
        //调用获取商品列表的方法
        productPresenter.getProductList(url);

    }

    /**
     *初始化view
     */
    protected void initView() {
        mProductRv = findViewById(R.id.rv_product);
        mProductRv.setLayoutManager(new GridLayoutManager(this,2));//网格布局管理器
//        mProductRv.setLayoutManager(new LinearLayoutManager(this));//线性布局管理器
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_product;
    }

    /**
     * p层回调过来的成功的方法
     * @param result
     */
    @Override
    public void success(String result) {

        ProductEntity productEntity = new Gson().fromJson(result,ProductEntity.class);


        ProductAdapter productAdapter = new ProductAdapter(this,productEntity.result);

        mProductRv.setAdapter(productAdapter);
        showToast(result);

    }
}
