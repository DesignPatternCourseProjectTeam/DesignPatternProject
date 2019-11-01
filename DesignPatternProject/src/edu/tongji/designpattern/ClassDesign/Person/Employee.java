package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Order.OrderAggregate;
import edu.tongji.designpattern.ClassDesign.Tools.InterPhoneChannel;
import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;


public abstract class Employee {
    protected OrderAggregate order;
    protected String employeeName;
    protected Gender employeeGender;
    protected Integer employeeAge;
    protected String employeeID;
    protected EmployeeTitle employeeTitle;
    public InterPhoneChannel myInterphoneChannel;


//    ////>>>>
//    public Employee(String employeeID){
//        this.employeeID = employeeID;
//    }


    protected AirConditionerAPI airConditionerAPI;

    public Employee(String employeeID,AirConditionerAPI airConditionerAPI){
        this.employeeID = employeeID;
        this.airConditionerAPI= airConditionerAPI;
    }



    public abstract void changeTmp();
    public abstract void update();
    public abstract void settleComplaint();

    //// process the massage received
    public void getMessage(String msg){
        System.out.println(this.employeeID+" receive message "+msg);
    }

    public abstract void sendMessage();

    public Boolean setChannel(InterPhoneChannel channel){this.myInterphoneChannel = channel; return true;}
    protected abstract void notifyChannel(BroadcastType broadcastType, String operation);
    public EmployeeTitle getTitle(){return this.employeeTitle;}
    public String getEmployeeID(){return this.employeeID;}
}


