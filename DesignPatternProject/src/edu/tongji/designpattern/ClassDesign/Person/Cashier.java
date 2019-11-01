package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;

public class Cashier extends Employee {

    private double temperature;

    public Cashier(String employeeID,double temperature,AirConditionerAPI airConditionerAPI) {
        super(employeeID,airConditionerAPI);
        this.temperature=temperature;
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
    public void getMessage(String msg) {

    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void notifyChannel(BroadcastType broadcastType, String operation) {

    }

}
