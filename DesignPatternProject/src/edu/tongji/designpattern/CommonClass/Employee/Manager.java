package edu.tongji.designpattern.CommonClass.Employee;


import edu.tongji.designpattern.CommonClass.Other.BroadcastType;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.AirConditionerAPI;

public class Manager extends Employee {

    private double temperature;

    /**
     * @description: 构造函数，除去父类参数，还有温度参数temperature
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public Manager(double temperature, String employeeID, EmployeeTitle employeeTitle, AirConditionerAPI airConditionerAPI) {
        super();
        this.temperature=temperature;
        this.employeeTitle = EmployeeTitle.MANAGER;
    }

    //经理解决顾客投诉的方法，使用的是责任链模式，zhujitao
    @Override
    public void settleComplaint(){
        System.out.println("您好，我是本店的经理，请问您有什么问题吗?");
        System.out.println("我已经了解了事情的经过，确实是我们的工作疏忽，我们一定会妥善解决的。");
        System.out.println("您好，我们会为您的本次就餐提供A类优惠卷，在结账时会提供6.8折优惠。");
        System.out.println("非常抱歉，同时祝您就餐愉快！");
    }


    /**
     * @description: 用于实现桥接模式
     *               重写的改变空调温度函数
     *               支持Manager操作
     * @Param:
     * @return:
     * @author: Cheng
     **/
    @Override
    public void changeTemperature() {
        System.out.println("大堂经理修改空调温度——");
        airConditionerAPI.changeTem(temperature);
    }

    @Override
    public void update() {

    }


    @Override
    public void getMessage(String msg) {

    }

    public boolean notifyWaitersToService(){
        if (this.myInterphoneChannel == null)
            return false;
        return this.myInterphoneChannel.notify(this,
                    "new service",
                    BroadcastType.ALL_WAITER);
    }

    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {

    }


}
