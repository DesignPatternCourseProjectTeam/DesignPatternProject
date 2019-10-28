
package edu.tongji.designpattern.ClassDesign.Person;

import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.AirConditionerAPI;
import edu.tongji.designpattern.ClassDesign.Business.Facade.OpenerMaker;
import edu.tongji.designpattern.ClassDesign.Business.PrototypeMementoDemo.Item;
import edu.tongji.designpattern.ClassDesign.Order.Order;

public class Waiter extends Employee {

    Customer customer;
    public OpenerMaker openerMaker;//ruan
    private double temperature;
    //默认构造函数：ruan
  public Waiter(){
       super();
   }



    //ruan
    public Waiter(double temperature, AirConditionerAPI airConditionerAPI, Order order) {
        super(airConditionerAPI);
        this.order=order;
        this.order.addEmploy(this);
        this.temperature= temperature;
    }

    public void getState(Customer customer){
        System.out.println("顾客现在的状态是：");
    }



    @Override
    public void settleComplaint() {
        System.out.println("您好，请问您有什么问题吗?");
        System.out.println("好的，我们会催促后厨尽快为您准备食物，请您稍等片刻！");
        System.out.println("非常抱歉，同时祝您就餐愉快！");
    }

    @Override
    public void changeTmp() {
        System.out.println("服务员修改空调温度——");
        airConditionerAPI.changeTem(temperature);
    }
    //ruan
    @Override
    public void update() {
        if(order.getOrderState()==0)
            System.out.println("class Waiter: method update:新订单创建！服务员等待接菜");
        else
            System.out.println("class Waiter: method update:订单完成！服务员开始上菜");
    }
    public void getDrinkList(Order order){
        openerMaker=new OpenerMaker();
        for (Item item : order.getItemList()) {
            if (item.getName() == "百威啤酒" || item.getName() == "酸梅汁"|| item.getName() == "可乐"|| item.getName() == "雪碧") {
                if (item.getName() == "百威啤酒") {
                    openerMaker.openBeer();
                }
                else if(item.getName() == "可乐")
                    openerMaker.openCock();
                else if (item.getName() == "雪碧")
                    openerMaker.openSprite();
                else
                    openerMaker .openDarkPlumJuice();
            }
        }
    }


    @Override
    public void getMessage() {

    }

    @Override
    public void sendMessage() {

    }
}
