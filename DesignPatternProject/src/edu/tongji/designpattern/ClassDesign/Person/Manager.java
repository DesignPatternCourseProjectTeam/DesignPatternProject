package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;

public class Manager extends Employee {

    private double temperature;

    public Manager(String employeeID,double temperature,AirConditionerAPI airConditionerAPI) {
        super(employeeID,airConditionerAPI);
        this.temperature=temperature;
    }

    @Override
    public void changeTmp() {
        System.out.println("大堂经理修改空调温度——");
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

    public boolean notifyWaitersToService(){
        if (this.myInterphoneChannel == null)
            return false;
        return this.myInterphoneChannel.notify(this,
                    "new service",
                    BroadcastType.ALL_EMPLOYEE);
    }

    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {

    }


}
