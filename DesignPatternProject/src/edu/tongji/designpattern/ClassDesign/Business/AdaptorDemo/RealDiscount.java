package edu.tongji.designpattern.ClassDesign.Business.AdaptorDemo;

/*
 * created by zhujitao
 * 2019/10/22
 * 实际得到具体折扣的类，通过输入的字符串返回不同的折扣比例
 * */

public class RealDiscount implements Discount {

    DiscountAdapter discountAdapter = null;
    String couponType = "";


    public RealDiscount(String couponType){
        this.couponType = couponType;
    }

    @Override
    public double getDiscount() {
        discountAdapter = new DiscountAdapter(couponType);
        return discountAdapter.getDiscount();
    }
}
