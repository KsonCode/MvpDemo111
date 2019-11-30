package com.bwie.okhttpdemo.model;

import com.bwie.okhttpdemo.api.Api;
import com.bwie.okhttpdemo.utils.NetUtils;

import java.util.HashMap;

/**
 * 数据模型层
 */
public class ProductModel {

    /**
     *
     */
    public void getProductList(String url, final ModelCallback modelCallback){

        NetUtils.getInstance().getJson(url, new NetUtils.MyCallBack() {
            @Override
            public void onGetJson(String json) {
                if (modelCallback!=null){
                    modelCallback.getJson(json);//回调出去，给调用者
                }
            }
        });
    }

//    //声明接口引用
//    private ModelCallback modelCallback;
//
//    /**
//     * 暴露公共方法，以便初始化,提供给调用者进行初始化
//     * @param modelCallback
//     */
//    public void setModelCallback(ModelCallback modelCallback) {
//        this.modelCallback = modelCallback;
//    }


    /**
     * 声明接口类
     */
    public interface  ModelCallback{
        void getJson(String result);
    }
}
