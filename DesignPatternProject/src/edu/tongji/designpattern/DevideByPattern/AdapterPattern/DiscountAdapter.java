package edu.tongji.designpattern.DevideByPattern.AdapterPattern;

/*
 * created by zhujitao
 * 2019/10/22
 * 优惠卷的适配器，通过输入的字符串返回不同的折扣比例
 * */

public class DiscountAdapter implements Discount {

    Coupon coupon = null;
    private  String couponType = "";

    public DiscountAdapter(String couponType){
        this.couponType = couponType;
    }

    //根据参数的不同来创建不同种类优惠卷，并且返回该优惠卷的折扣值
    @Override
    public double getDiscount() {
        if(couponType.equals("A")){
            coupon = new CouponA();
        }else if(couponType.equals("B")){
            coupon = new CouponB();
        }else if(couponType.equals("C")){
            coupon = new CouponC();
        }
        return coupon.returnDiscount();
    }

}
