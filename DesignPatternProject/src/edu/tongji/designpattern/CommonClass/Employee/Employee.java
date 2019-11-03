package edu.tongji.designpattern.CommonClass.Employee;


import edu.tongji.designpattern.CommonClass.Other.BroadcastType;
import edu.tongji.designpattern.DevideByPattern.MediatorPattern.InterPhoneChannel;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.AirConditionerAPI;


public abstract class Employee {

    protected Order order;
    protected Gender employeeGender;
    protected String employeeID;
    protected EmployeeTitle employeeTitle;
    public InterPhoneChannel myInterphoneChannel;

    //属性：空调接口，protected类型
    protected AirConditionerAPI airConditionerAPI;


    /**
    * @description: 抽象类Employee的构造函数，包含三个参数
     *              employeeID、employeeTitle是职工的固有属性
     *              airConditionerAPI是空调调用接口
    * @Param:
    * @return:
    * @author: Cheng
    * @created: 2019/11/2/19:05
    **/
    public Employee(String employeeID, EmployeeTitle employeeTitle,AirConditionerAPI airConditionerAPI){
        this.employeeID=employeeID;
        this.employeeTitle=employeeTitle;
        this.airConditionerAPI=airConditionerAPI;
    }



    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 职工类的默认构造函数
     */
    public Employee() {

    }


    /**
    * @description: 改变空调温度的函数
    * @Param:
    * @return:
    * @author: Cheng
    **/
    public abstract void changeTemperature();


    /**
     * @author ruanby
     * @date  11/2
     * @return null
     * @function 订单状态改变后，对服务员和厨师的工作状态进行更新，由厨师和服务员进行重写
     */
    public abstract void update();


    public abstract void settleComplaint();

    //// process the massage received
    public void getMessage(String msg){
        System.out.println(this.employeeID+" receive message "+msg);
    }




  public Order getOrder() {
       return order;
 }

    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 职工属性中订单的set方法，会被厨师和服务员类重写
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    public Boolean setChannel(InterPhoneChannel channel){this.myInterphoneChannel = channel; return true;}
    protected abstract void notifyChannel(BroadcastType broadcastType, String operation);
    public EmployeeTitle getTitle(){return this.employeeTitle;}
    public String getEmployeeID(){return this.employeeID;}
}


