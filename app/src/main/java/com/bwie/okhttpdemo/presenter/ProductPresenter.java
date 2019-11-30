package com.bwie.okhttpdemo.presenter;

import com.bwie.okhttpdemo.model.ProductModel;
import com.bwie.okhttpdemo.view.IProductView;

import java.util.HashMap;

/**
 * p层，逻辑处理层，控制器
 */
public class ProductPresenter {

    private ProductModel productModel;
    private IProductView iProductView;

    public ProductPresenter(IProductView iProductView){
        productModel = new ProductModel();
        this.iProductView = iProductView;
    }

    public void getProductList(String url){


        if (productModel!=null){
            productModel.getProductList(url, new ProductModel.ModelCallback() {
                @Override
                public void getJson(String result) {

                    iProductView.success(result);

                }
            });
        }



    }
}
