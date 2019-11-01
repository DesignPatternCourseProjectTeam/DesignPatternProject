package edu.tongji.designpattern;


import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.FloorAirConditioner;
import edu.tongji.designpattern.ClassDesign.Business.AirConditionerAPI.HangingAirConditioner;
import edu.tongji.designpattern.ClassDesign.Business.Builder.ComboBuilder;
import edu.tongji.designpattern.ClassDesign.Business.Builder.ConcreteComboBuilderA;
import edu.tongji.designpattern.ClassDesign.Business.Builder.ConcreteComboBuilderB;
import edu.tongji.designpattern.ClassDesign.Business.Builder.Director;
import edu.tongji.designpattern.ClassDesign.Business.MenuSource.MenuSource;
import edu.tongji.designpattern.ClassDesign.Business.MenuSource.ProxyMenuSource;
import edu.tongji.designpattern.ClassDesign.Person.*;
import edu.tongji.designpattern.ClassDesign.Tools.Combo;


public class Main {

    //// 合并的时候这里写单元测试，加上自己的函数
    public class Debug{
        public void eyishengTest1(){
            System.out.println("hello world");
        }
    }

    /*
        我定义了一些 Enum type，修改了你们的参数，但是输出时没有改
     */
    public static void main(String[] args) {


//test for StatePattern
        //初始时根据时间不同来让顾客的状态发生变化
        //感觉需要有一个更好的办法
        //顾客的点餐、等待、就餐等状态之间的变化需要的参数应当不是同一个
        //或者是同一个参数（时间），但如何传、由谁传递需要决定
        Customer customer= new Customer();
        customer.setTime(8);
        customer.getState();
        customer.setTime(9);
        customer.getState();
        customer.setTime(11);
        customer.getState();
        customer.setTime(21);
        customer.getState();
        customer.setTime(31);
        customer.getState();
        customer.setTime(41);
        customer.getState();




//test for BridgePattern
        //注册不同的职工来调用同一个接口API的不同实体类
        Employee waiter1 = new Waiter("waiter1",24,new FloorAirConditioner());
        Employee manager = new Manager("waiter2",25,new HangingAirConditioner());

        waiter1.changeTmp();
        manager.changeTmp();


//test for CompositePattern
        //注册的四名顾客
        Customer customer1=new Customer("张先生", Gender.MALE,VIPType.VIP);
        Customer customer2=new Customer("张女士", Gender.FEMALE,VIPType.VIP);
        Customer customer3=new Customer("张先生", Gender.MALE,VIPType.NONVIP);
        Customer customer4=new Customer("张女士",Gender.FEMALE,VIPType.NONVIP);

        //通过是否为VIP将VIP顾客和非VIP顾客加入不同的List里面
        //感觉需要更好的划分方法（或者应该有判断语句来自动划分顾客种类？
        customer1.add(customer2);
        customer3.add(customer4);

        System.out.println(customer1);
        System.out.println(customer3);

//test for ProxyPattern
        MenuSource source=new ProxyMenuSource("pictureOfDish.jpg");
        //资源文件需要从磁盘加载
        source.show();
        System.out.println(" ");
        //资源文件不需要从磁盘加载
        source.show();


//test for BuilderPattern
        ComboBuilder comboBuilder1= new ConcreteComboBuilderA();
        ComboBuilder comboBuilder2= new ConcreteComboBuilderB();
        Director director1 =new Director(comboBuilder1);
        Director director2 =new Director(comboBuilder2);
        Combo comboA=director1.construct();
        Combo comboB=director2.construct();


        ////<<<< eatamath debug
//        ArrayList<Employee> arr = new ArrayList<>();
//        Manager manager = new Manager("manager");
//        arr.add(manager);
//        Waiter wt1 = new Waiter("waiter 1");
//        Waiter wt2 = new Waiter("waiter 2");
//        arr.add(wt1);
//        arr.add(wt2);
//
//        InterPhoneChannel phone = InterPhoneChannel.getInstance(arr);
//
//        var res = manager.notifyWaitersToService();
//        System.out.println(res);




    }
}
