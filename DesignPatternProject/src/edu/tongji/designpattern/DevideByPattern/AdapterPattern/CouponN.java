package edu.tongji.designpattern.DevideByPattern.AdapterPattern;

/*
 * created by zhujitao
 * 2019/10/22
 * N类优惠卷，就是没有优惠卷，不享受任何优惠
 * */

public class CouponN implements Coupon {

    final String type = "N";
    final double discountPercentage = 0.0;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double returnDiscount() {
        return discountPercentage;
    }
}

