package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;

enum Gender{
    MALE, FEMALE
}

public abstract class Employee {
//    private AirConditionerAPI airConditionerAPI;
    private Order order;
    private  String employeeName;
    private Gender employeeGender;
    private Integer employeeAge;
    public String employeeID;
//    public InterphoneChannel myInterphoneChannel;


    protected AirConditionerAPI airConditionerAPI;

    public Employee(AirConditionerAPI airConditionerAPI){
        this.airConditionerAPI= airConditionerAPI;
    }



    public abstract void changeTmp();
    public abstract void update();
    public abstract void settleComplaint();
    public abstract void getMessage();
    public abstract void sendMessage();

}


