package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AdaptorDemo.RealDiscount;
import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;
import edu.tongji.designpattern.ClassDesign.Order.Order;

import java.text.DecimalFormat;

public class Cashier extends Employee {

    private double temperature;


    Order order;
    String couponType;
    RealDiscount realDiscount;

    public Cashier(double temperature,AirConditionerAPI airConditionerAPI, Order order, String couponType) {
        super(airConditionerAPI);
        this.temperature=temperature;

        this.order = order;
        this.couponType = couponType;
        realDiscount = new RealDiscount(couponType);
    }

//    public Cashier(Order order, String couponType){
//        this.order = order;
//        this.couponType = couponType;
//        realDiscount = new RealDiscount(couponType);
//    }

    public void settleAccount(){
        //这里执行结账操作，结账成功返回true
        if(couponType.equals("N")){
            System.out.println("您本次就餐共花费了"+order.getPrice()+"元，欢迎下次再来");
        }else {
            DecimalFormat df = new DecimalFormat( "0.0");
            System.out.println("您的优惠卷是" + couponType + "类型的，可以享受" + df.format(realDiscount.getDiscount() * 10) + "折优惠。");
            System.out.println("您本次就餐原价是" + order.getPrice() + "元,折后价是" + order.getPrice() * realDiscount.getDiscount() + "元。");
        }
    }

    @Override
    public void changeTmp() {
        System.out.println("收银员修改空调温度——");
        airConditionerAPI.changeTem(temperature);
    }

    @Override
    public void update() {

    }

    @Override
    public void settleComplaint() {

    }

    @Override
    public void getMessage() {

    }

    @Override
    public void sendMessage() {

    }
}
