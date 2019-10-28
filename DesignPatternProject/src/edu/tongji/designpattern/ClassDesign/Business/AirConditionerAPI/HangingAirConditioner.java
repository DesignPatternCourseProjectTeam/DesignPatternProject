package edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI;

public class HangingAirConditioner implements AirConditionerAPI{
    @Override
    public void changeTem(double temperature) {
        System.out.println("修改挂式空调温度为："+temperature);
    }
}
