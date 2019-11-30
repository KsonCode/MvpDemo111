package com.bwie.okhttpdemo.entity;

import java.util.List;

public class ProductEntity {

    public String message;
    public String status;


    public List<Product> result;
    public static class Product{
        public String commodityId;
        public String commodityName;
        public String masterPic;
        public String price;
        public String saleNum;
    }




}
