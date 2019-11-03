package edu.tongji.designpattern.CommonClass.Employee;


import edu.tongji.designpattern.CommonClass.Other.BroadcastType;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.AirConditionerAPI;

public class Cook extends Employee {

    private double temperature;

    /**
     * @description: 构造函数，除去父类参数，还有温度参数temperature
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public Cook(double temperature, String employeeID, EmployeeTitle employeeTitle, AirConditionerAPI airConditionerAPI, Order order) {
        super();
        this.temperature=temperature;
        this.employeeTitle=employeeTitle.COOK;
    }

    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 厨师的默认构造函数
     */
    public Cook(){
        super();
    }



    /**
     * @description: 用于实现桥接模式
     *              重写的改变空调温度函数
     *              不支持Cook操作
     * @Param:
     * @return:
     * @author: Cheng
     **/
    @Override
    public void changeTemperature() {
    }


    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 将order参数从厨师的构造函数中分离，订单创建后，将厨师加入订单的通知列表中
     */
    @Override
    public void setOrder(Order order) {
        this.order=order;
        this.order.addEmploy(this);
    }


    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 订单状态改变后，更新厨师的行为：接受到新订单，厨师开始做菜；订单完成，厨师等待服务员接菜
     */
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
    public void getMessage(String msg) {

    }



    @Override
    protected void notifyChannel(BroadcastType broadcastType, String operation) {
        try{
            if (broadcastType == BroadcastType.ALL_WAITER){

            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


}
