package edu.tongji.designpattern.ClassDesign.Business.AdaptorDemo;/*
* created by zhujitao
* 2019/10/22
* C类优惠卷，可以享受9.8折优惠
* */

public class CouponC implements Coupon {

    final String type = "A";
    final double discountPercentage = 0.98;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double returnDiscount() {
          return discountPercentage;
    }
}
