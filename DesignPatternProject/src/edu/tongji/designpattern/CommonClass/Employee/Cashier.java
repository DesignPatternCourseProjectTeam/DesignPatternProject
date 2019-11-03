package edu.tongji.designpattern.CommonClass.Employee;


import edu.tongji.designpattern.CommonClass.Other.BroadcastType;
import edu.tongji.designpattern.DevideByPattern.AdapterPattern.RealDiscount;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.AirConditionerAPI;

import java.text.DecimalFormat;

public class Cashier extends Employee {

    private double temperature;


    //当前订单所使用的优惠卷
    String couponType;
    //适配器模式使用的类
    RealDiscount realDiscount;

    /**
     * @description: 构造函数，除去父类参数，还有温度参数temperature
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public Cashier(double temperature, String employeeID, EmployeeTitle employeeTitle, AirConditionerAPI airConditionerAPI, String couponType) {
        super();
        this.temperature=temperature;
        this.employeeTitle=employeeTitle.CASHIER;
        this.couponType = couponType;
        realDiscount = new RealDiscount(couponType);
    }

    //收银员处理订单的函数,使用了适配器模式，zhujitao
    public void settleAccount(){
        //这里执行结账操作，结账成功返回true
        if(couponType.equals("N")){
            System.out.println("您本次就餐共花费了"+getOrder().getPrice()+"元，欢迎下次再来");
        }else {
            DecimalFormat df = new DecimalFormat( "0.0");
            System.out.println("您的优惠卷是" + couponType + "类型的，可以享受" + df.format(realDiscount.getDiscount() * 10) + "折优惠。");
            System.out.println("您本次就餐原价是" + order.getPrice() + "元,折后价是" + order.getPrice() * realDiscount.getDiscount() + "元。");
        }
    }

    /**
     * @description: 用于实现桥接模式
     *              重写的改变空调温度函数
     *              不支持Cashier操作
     * @Param:
     * @return:
     * @author: Cheng
     **/
    @Override
    public void changeTemperature() {
    }

    @Override
    public void update() {

    }

    @Override
    public void settleComplaint() {

    }

    @Override
    public void getMessage(String msg) {

    }



    @Override
    public void notifyChannel(BroadcastType broadcastType, String operation) {

    }

}
