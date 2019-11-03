package edu.tongji.designpattern.CommonClass.Customer;


import edu.tongji.designpattern.CommonClass.Employee.Gender;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Other.Dish;
import edu.tongji.designpattern.DevideByPattern.CommandPattern.*;
import edu.tongji.designpattern.DevideByPattern.StatePattern.CustomerState;
import edu.tongji.designpattern.DevideByPattern.StatePattern.OrderState;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    ////<<<<
    private String customerName;
    private Gender customerGender;
    private VIPType viptype = VIPType.NONVIP;
    private List<Customer> customers;
    private CustomerState customerState;
    private double time; //目前是传递一个时间参数，来控制顾客的状态变化
    private OrderPadCommand myCommand;
    private Waiter servedWaiter;



    /**
    * @description: 用于状态模式
     *              在构造函数中将顾客状态定义为等待状态
    * @Param:
    * @return:
    * @author: Cheng
    **/
    public Customer(){
        customerState = new OrderState();
    }

    /**
     * @description: 带参构造函数，实现组合模式
     *               每次生成顾客对象的时候生成一个List来存放顾客
     *               VIP和非VIP顾客作为树的两个叶子节点
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public Customer(String name, Gender gender, VIPType VIPORNOT){
        this.customerName = name;
        this.customerGender = gender;
        this.viptype = VIPORNOT;
        customers = new ArrayList<Customer>();
    }

    /**
    * @description: 用于状态模式
     *              顾客获取一个参数（目前设为时间）
     *              以此来判断顾客的状态
    * @Param:
    * @return:
    * @author: Cheng
    **/
    public double getTime() {
        return time;
    }

    /**
    * @description: 用于状态模式
     *              给顾客传递预设参数（目前设为时间）
     *              用于状态判断
    * @Param: double time
    * @return:
    * @author: Cheng
    **/
    public void setTime(double time) {
        this.time = time;
    }

   /**
   * @description: 用于状态模式
    *              将顾客的状态初始化为点单状态
   * @Param: CustomerState customerState
   * @return:
   * @author: Cheng
   **/
    public void setState(CustomerState customerState){
        this.customerState= customerState;
    }

    /**
    * @description: 用于状态模式
     *              获取顾客的状态
    * @Param:
    * @return:
    * @author: Cheng
    **/
    public void getState(){
        customerState.getState(this);
    }



    /**
    * @description: 用于组合模式
     *              对一个List执行add操作
    * @Param:
    * @return:
    * @author: Cheng
    **/
    public void add(Customer c){
        customers.add(c);
    }

    /**
     * @description: 用于组合模式
     *              对一个List执行aremove操作
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public void remove(Customer c){
        customers.remove(c);
    }

    /**
     * @description: 用于组合模式
     *               生成一个顾客的List
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * @description: 用于组合模式
     *               输出顾客的信息
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public String toString(){
        return ("顾客：[姓名："+this.customerName
                +"，性别："+this.customerGender+", 是否为VIP客户"
                +this.viptype+"]");
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

    //下面函数是组合模式所需函数，用于顾客对象加入一个队列中，形成分层
    //树形结构，可以铜鼓VIP与否将顾客加入不同列表中

}
