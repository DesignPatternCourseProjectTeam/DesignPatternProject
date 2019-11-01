package edu.tongji.designpattern.ClassDesign.Business.AdaptorDemo;/*
 * created by zhujitao
 * 2019/10/22
 * B类优惠卷，可以享受8.8折优惠
 * */

public class CouponB implements Coupon {

    final String type = "B";
    final double discountPercentage = 0.88;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double returnDiscount() {
          return discountPercentage;
    }
}
