package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;
import edu.tongji.designpattern.ClassDesign.Business.OrderRecording.AddDishStrategy;
import edu.tongji.designpattern.ClassDesign.Business.OrderRecording.OrderConfirmStrategy;
import edu.tongji.designpattern.ClassDesign.Business.OrderRecording.OrderCreateStrategy;
import edu.tongji.designpattern.ClassDesign.Business.OrderRecording.*;
import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

////>>>>
public class Waiter extends Employee {

    Customer customer;
    private double temperature;
    private Order currentOrder = null;
    private OrderRecordingStrategy strategy = null;


    public Waiter(String employeeID,double temperature,AirConditionerAPI airConditionerAPI) {
        super(employeeID,airConditionerAPI);
        this.temperature= temperature;
        this.employeeTitle = EmployeeTitle.WAITER;
    }

    public void getState(Customer customer){
        System.out.println("顾客现在的状态是：");
    }

    @Override
    public void changeTmp() {
        System.out.println("服务员修改空调温度——");
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
        System.out.println(this.employeeID+" receive "+msg);
    }

    @Override
    public void sendMessage() {

    }

    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {

    }


    public void clearOrder(){
        this.order = null;
    }

    public void createOrderForCustomer(){
        OrderCreateStrategy strategy = new OrderCreateStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(null,null);
    }

    public void confirmOrderForCustomer(){
        OrderConfirmStrategy strategy = new OrderConfirmStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(null,this.currentOrder);
    }
    
    public void addDishForCustomer(Dish dish){
        AddDishStrategy strategy = new AddDishStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(dish,this.currentOrder);
    }

    public void dropDishForCustomer(Dish dish){
        DropDishStrategy strategy = new DropDishStrategy();
        this.setStrategy(strategy);
        this.currentOrder = this.strategy.execute(dish,this.currentOrder);
    }

    private void setStrategy(OrderRecordingStrategy strategy) {
        this.strategy = strategy;
    }


}
