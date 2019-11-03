package edu.tongji.designpattern.DevideByPattern.AdapterPattern;
/*
 * created by zhujitao
 * 2019/10/22
 * A类优惠卷，可以享受6.8折优惠
 * */

public interface Coupon {

    //优惠卷的类型
    final String type = "";
    //实际折扣
    final double discountPercentage = 0;

    //返回折扣数值的函数
    public double returnDiscount();

    public String getType();

}
