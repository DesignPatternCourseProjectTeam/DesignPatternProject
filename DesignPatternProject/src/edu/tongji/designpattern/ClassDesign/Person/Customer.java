package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.State.CustomerState;
import edu.tongji.designpattern.ClassDesign.Business.State.OrderState;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String gender;
    private Integer VIPORNOT;//默认1为VIP，0为非VIP
    private List<Customer> customers;
    private CustomerState customerState;
    private double time; //目前是传递一个时间参数，来控制顾客的状态变化


    public Customer(String name, String gender,Integer VIPORNOT){
        this.name=name;
        this.gender=gender;
        this.VIPORNOT=VIPORNOT;
        customers=new ArrayList<Customer>();
    }
    public Customer(){
        //初始化为点单状态
        customerState = new OrderState();
    }



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
        return ("顾客：[姓名："+name+"，性别："+gender+", 是否为VIP客户"+VIPORNOT+"]");
    }
}
