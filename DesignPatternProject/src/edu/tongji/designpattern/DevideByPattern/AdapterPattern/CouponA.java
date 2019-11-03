package edu.tongji.designpattern.DevideByPattern.AdapterPattern;

/*
 * created by zhujitao
 * 2019/10/22
 * A类优惠卷，可以享受6.8折优惠
 * */

public class CouponA implements Coupon {

    final String type = "A";
    final double discountPercentage = 0.68;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double returnDiscount() {
          return discountPercentage;
    }
}
