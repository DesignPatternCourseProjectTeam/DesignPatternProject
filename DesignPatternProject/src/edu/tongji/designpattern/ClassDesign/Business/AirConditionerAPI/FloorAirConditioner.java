package edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI;

public class FloorAirConditioner implements AirConditionerAPI {
    @Override
    public void changeTem(double temperature) {
        System.out.println("修改立式空调温度为："+temperature);
    }
}
