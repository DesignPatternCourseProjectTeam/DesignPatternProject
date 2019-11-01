package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;

public class Cook extends Employee {

    private double temperature;

    public Cook(String employeeID,double temperature,AirConditionerAPI airConditionerAPI) {
        super(employeeID,airConditionerAPI);
        this.temperature=temperature;
    }

    @Override
    public void changeTmp() {
        System.out.println("厨师修改空调温度——");
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
    protected void notifyChannel(BroadcastType broadcastType, String operation) {
        try{
            if (broadcastType == BroadcastType.ALL_EMPLOYEE){

            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


}
