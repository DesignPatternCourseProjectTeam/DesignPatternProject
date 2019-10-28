package edu.tongji.designpattern.ClassDesign.Business.AdaptorDemo;
/*
 * created by zhujitao
 * 2019/10/22
 * A类优惠卷，可以享受6.8折优惠
 * */

public interface Coupon {

    final String type = "";
    final double discountPercentage = 0;

    public double returnDiscount();

    public String getType();

}
