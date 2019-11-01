package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.Command.*;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;
import edu.tongji.designpattern.ClassDesign.Business.State.CustomerState;
import edu.tongji.designpattern.ClassDesign.Business.State.OrderState;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    ////<<<<
    private String customerName;
    private Gender customerGender;
//    private int customerAge = 0;
    private VIPType viptype = VIPType.NONVIP;

    ////>>>>>>>>
    private List<Customer> customers;
    private CustomerState customerState;
    private double time; //目前是传递一个时间参数，来控制顾客的状态变化


    private OrderPadCommand myCommand;
    private Waiter servedWaiter;

    public Customer(String name){
        this.customerName = name;
    }

    ////>>>>
    public Customer(String name, Gender gender,VIPType VIPORNOT){
        this.customerName = name;
        this.customerGender = gender;
        this.viptype = VIPORNOT;
        customers = new ArrayList<Customer>();
    }
    public Customer(){
        //初始化为点单状态
        customerState = new OrderState();
    }

    public void served(Waiter wt){
        this.servedWaiter = wt;
    }

    public void serviceEnd(){
        this.servedWaiter.clearOrder();
        this.servedWaiter = null;
    }

    private void setMyCommand(OrderPadCommand cmd){
        if (this.servedWaiter != null)
            myCommand = cmd;
        else
            System.out.println("ERROR: no serving waiter!");
    }


    public void setVIPType(){this.viptype = VIPType.VIP;}
    public boolean isVIP(){return this.viptype == VIPType.VIP;}

    private void executeCommand(){
        this.myCommand.execute();
    }

    public void addDishDemand(Dish dish){
        AddDishCommand cmd = new AddDishCommand(this.servedWaiter,dish);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }

    public void dropDishDemand(Dish dish){
        DropDishCommand cmd = new DropDishCommand(this.servedWaiter,dish);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }

    public void createOrderDemand(Dish dish){
        CreateOrderCommand cmd = new CreateOrderCommand(this.servedWaiter);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }

    public void confirmOrderDemand(Dish dish){
        ConfirmOrderCommand cmd = new ConfirmOrderCommand(this.servedWaiter);
        this.setMyCommand(cmd);
        this.myCommand.execute();
    }


    ////>>>>
    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    //将状态初始化为点单状态
    public void setState(CustomerState customerState){
        this.customerState= customerState;
    }

    public void getState(){
        customerState.getState(this);
    }

    //下面函数是组合模式所需函数，用于顾客对象加入一个队列中，形成分层
    //树形结构，可以铜鼓VIP与否将顾客加入不同列表中

    public void add(Customer c){
        customers.add(c);
    }
    public void remove(Customer c){
        customers.remove(c);
    }

    public List<Customer> getCustomers(){
        return customers;
    }
    public String toString(){
        return ("顾客：[姓名："+this.customerName
                +"，性别："+this.customerGender+", 是否为VIP客户"
                +this.viptype+"]");
    }
}
