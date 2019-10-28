package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;

public class Manager extends Employee {

    private double temperature;

    public Manager(double temperature,AirConditionerAPI airConditionerAPI) {
        super(airConditionerAPI);
        this.temperature=temperature;
    }

    //private static Manager instance = new Manager();

    //public static Manager getInstance() {
//        return instance;
//    }

    //解决顾客投诉的方法
    @Override
    public void settleComplaint(){
        System.out.println("您好，我是本店的经理，请问您有什么问题吗?");
        System.out.println("我已经了解了事情的经过，确实是我们的工作疏忽，我们一定会妥善解决的。");
        System.out.println("您好，我们会为您的本次就餐提供A类优惠卷，在结账时会提供6.8折优惠。");
        System.out.println("非常抱歉，同时祝您就餐愉快！");
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
    public void getMessage() {

    }

    @Override
    public void sendMessage() {

    }
}
