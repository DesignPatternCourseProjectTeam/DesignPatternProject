package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;
import edu.tongji.designpattern.ClassDesign.Order.Order;

public class Cook extends Employee {

    private double temperature;
//ruan
    public Cook(double temperature, AirConditionerAPI airConditionerAPI, Order order) {
        super(airConditionerAPI);
        this.temperature=temperature;
        this.order=order;
        this.order.addEmploy(this);
    }
//ruan
    public Cook(){
        super();
    }
    @Override
    public void changeTmp() {
        System.out.println("厨师修改空调温度——");
        airConditionerAPI.changeTem(temperature);
    }

    @Override
    public void update() {
        if(order.getOrderState()==0)

            System.out.println("class Cook: method update:接受到新订单！厨师开始做菜");
        else

            System.out.println("class Cook: method update:订单完成！厨师等待服务员接菜");
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
