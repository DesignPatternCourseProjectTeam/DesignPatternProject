package edu.tongji.designpattern;

import edu.tongji.designpattern.CommonClass.Customer.Customer;
import edu.tongji.designpattern.CommonClass.Customer.VIPType;
import edu.tongji.designpattern.CommonClass.Employee.*;
import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Items.Menu;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.DevideByPattern.AdapterPattern.RealDiscount;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.FloorAirConditioner;
import edu.tongji.designpattern.DevideByPattern.BridgePattern.HangingAirConditioner;
import edu.tongji.designpattern.DevideByPattern.BuilderPattern.*;
import edu.tongji.designpattern.DevideByPattern.ChainofResponsibilityPattern.Complaint;
import edu.tongji.designpattern.DevideByPattern.DecoratorPattern.VIPCashierDecorator;
import edu.tongji.designpattern.DevideByPattern.MediatorPattern.InterPhoneChannel;
import edu.tongji.designpattern.DevideByPattern.PrototypePattern.Memento;
import edu.tongji.designpattern.DevideByPattern.PrototypePattern.OrderClone;
import edu.tongji.designpattern.dispatch.OrderDispatcher;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.*;


public class Main {

    //// 合并的时候这里写单元测试，加上自己的函数
    public class Debug{
        public class Eyisheng{

        }
    }

    /*
        我定义了一些 Enum type，修改了你们的参数，但是输出时没有改
     */
    public static void main(String[] args) throws InterruptedException{

        EmployeeTitle waiter=EmployeeTitle.WAITER;
        EmployeeTitle manager=EmployeeTitle.MANAGER;
        EmployeeTitle cook=EmployeeTitle.COOK;
        EmployeeTitle cashier=EmployeeTitle.CASHIER;

        /*
            创建所有 Employee
         */
        List<Employee> allEmployeeList = new ArrayList<>(); // 保存所有 Employee
        Waiter waiter1 = new Waiter("002",waiter,new FloorAirConditioner());
        Waiter waiter2 = new Waiter("000",waiter,new FloorAirConditioner());
        Manager manager1 = new Manager("001",manager,new HangingAirConditioner());
        Cashier cashier1 = new Cashier("003", cashier, new HangingAirConditioner(),"A");
        Cook cook1 =new Cook("004",cook,new HangingAirConditioner(),new Order());

        //组合模式：生成两个CustomerList，即VIP顾客和非VIP顾客
        Customer VIPCustomer = new Customer("",Gender.NONE,VIPType.VIP);
        Customer NONVIPCustomer = new Customer("",Gender.NONE,VIPType.NONVIP);

        allEmployeeList.add(waiter1);
        allEmployeeList.add(waiter2);
        allEmployeeList.add(manager1);
        allEmployeeList.add(cashier1);
        allEmployeeList.add(cook1);

        /*
            创建 Channel
         */
        InterPhoneChannel interPhoneChannel = InterPhoneChannel.getInstance(allEmployeeList);

        System.out.println("第一个顾客他来了，脚下生风，虎虎生威");
        Customer customer1=new Customer("张先生", Gender.MALE, VIPType.VIP);
        System.out.println("欢迎"+customer1.getCustomerName());

        //对讲机通知服务员顾客到了
        manager1.notifyWaitersToService();
        manager1.scheduleWaiterToService(customer1,(ArrayList<Employee>) allEmployeeList);

        /*
            显示菜单
         */
        System.out.println("菜单如下，请您点餐：（输入编号即可,每个编号中间以空格隔开，换行结束）");
        Menu menu = Menu.getInstance();
        menu.showMenu();

        /*
            顾客点菜
         */
        Order currentOrder =new Order();
        Scanner scan = new Scanner(System.in);
        System.out.println("是否选择套餐？（是选择1，否选择0）");
        String comboOrNot = scan.nextLine().toString();
        if(comboOrNot.equals("1")){
            ComboBuilder comboBuilder1= new ConcreteComboBuilderA();
            ComboBuilder comboBuilder2= new ConcreteComboBuilderB();
            Director director1 =new Director(comboBuilder1);
            Director director2 =new Director(comboBuilder2);
            Combo comboA=director1.construct();
            Combo comboB=director2.construct();
            System.out.println("请选择套餐编号:");
            String comboNum =scan.nextLine().toString();
            if(comboNum.equals("1")){
                comboBuilder1.buildItemList();
                currentOrder.setItemList(comboBuilder1.getItemList());
                currentOrder.setPrice(comboBuilder1.getPrice());
            }
            else{
                comboBuilder2.buildItemList();
                currentOrder.setItemList(comboBuilder2.getItemList());
                currentOrder.setPrice(comboBuilder2.getPrice());
            }
        }else {
            while (true){
                System.out.println("======请输入命令======");
                System.out.println(
                        "1***创建订单\tcreate order\n" +
                                "2***添加菜品\tadd dish\n" +
                                "3***删除菜品\tdrop dish\n" +
                                "4***确认订单\tconfirm order\n" +
                                "5***查看菜单\tshow menu\n" +
                                "6***查看订单\tshow order\n" +
                                "====================="
                );

                boolean flag = false;
                String line = scan.nextLine();
                System.out.println(line);
//            Waiter servingWaiter = customer1.getServingWaiter();
                if (line.equals("create order")){
                    customer1.createOrderDemand();
                }
                else if (line.equals("add dish")){
                    System.out.println("请输入菜名所对应的编号");
                    Integer idx = -1;
                    boolean normal = true;
                    while (true) {
                        try {
                            idx = scan.nextInt()-1; //// indexation bias
                            break;
                        } catch (Exception e) {
                            System.out.println("ERROR: invalid input");
                            normal = false;
                            break;
                        }finally {
                            scan = new Scanner(System.in);
                        }
                    }
                    if (normal) {
                        Item newItem = menu.getItem(idx);
                        if (newItem != null)
                            customer1.addDishDemand(newItem);
                    }
                }
                else if (line.equals("drop dish")){
                    System.out.println("请输入菜名所对应的编号");
                    Integer idx = -1;
                    boolean normal = true;
                    while (true) {
                        try {
                            idx = scan.nextInt()-1;// indexation bias
                            break;
                        } catch (Exception e) {
                            System.out.println("ERROR: invalid input");
                            normal = false;
                            break;
                        }finally {
                            scan = new Scanner(System.in);
                        }
                    }
                    if (normal) {
                        Item delItem = menu.getItem(idx);
                        if (delItem != null)
                            customer1.dropDishDemand(delItem);
                    }
                }
                else if (line.equals("confirm order")){
                    while (true) {
                        try {
                            System.out.println("confirm? y/[n]");
                            String ch = scan.next();
                            if (ch.equals("y")){
                                customer1.confirmOrderDemand();
                                flag = true;
                                Waiter servingWaiter = customer1.getServingWaiter();
                                currentOrder = servingWaiter.getCurrentOrder();
                                servingWaiter.clearOrder();
                                customer1.serviceEnd();
                                break;
                            }
                            else if (ch.equals("n")){
                                break;
                            }
                        }catch (Exception e){
                            System.out.println("ERROR: invalid input");
                        }finally {
                            scan = new Scanner(System.in);
                        }
                    }
                }
                else if (line.equals("show menu")){
                    menu.showMenu();
                }
                else if (line.equals("show order")){
                    customer1.showOrderDemand();
                }
                else{
                    System.out.println("**********\n命令错误，请重新输入\n**********");
                }
                if (flag){
                    break;
                }
            }
        }


        //传给后厨菜单order并设置订单状态
        Order order = currentOrder;

        //观察者模式
        waiter1.setOrder(order);
        cook1.setOrder(order);
        order.setOrderState(0);

        //使用备忘录来备份order
        OrderClone orderClone = new OrderClone(order);
        OrderClone orderClone1 = (OrderClone)orderClone.clone();
        Memento memento = new Memento();
        memento.addOrderClone(orderClone1);
        //获取备份的order
        //memento.getOrderClone(1);


        //分支事件
        System.out.println("请您耐心等候，正在为您处理订单，如果有需要请联系服务员！");
        System.out.println("如果想要修改空调温度，请输入 1 :");
        System.out.println("如果想要进行投诉，请输入 2 :");
        System.out.println("如果没有什么需求，请输入 3 :");
        String ask = scan.nextLine().toString();
        //通过状态进行推出
        while (!ask.equals("3")){
            if(ask.equals("2")){
                System.out.println("请您选择投诉的类型:");
                System.out.println("上菜太慢请输入1");
                System.out.println("其他投诉请输入2");
                String complaintType = scan.nextLine().toString();
                Complaint complaint = new Complaint(complaintType, manager1, waiter1);
                complaint.setCurHanlder();
                complaint.getEmployee().settleComplaint();
            }else if(ask.equals("1")){
                System.out.println("请输入您想选择的温度:");
                String temperature = scan.nextLine().toString();
                Double t=Double.parseDouble(temperature);
                waiter1.setTemperature(t);
                waiter1.changeTemperature();
            }
            System.out.println("请您耐心等候，正在为您处理订单，如果有需要请联系服务员！");
            System.out.println("如果想要修改空调温度，请输入 1 :");
            System.out.println("如果想要进行投诉，请输入 2 :");
            System.out.println("如果没有什么需求，请输入 3 :");
            ask = scan.nextLine().toString();
        }


        //后厨需要的参数和调度器设置
        order.setID(1);
        OrderDispatcher dispatcher = new OrderDispatcher();
        dispatcher.addOrder(order);


//        //外观模式：服务员检查订单是否有酒水，如果有则取酒水
//        waiter1.getDrinkList(order);
//
//        //菜做完、酒水取完后，订单状态改变
//        order.setOrderState(1);
//
//        //顾客开始就餐到就餐结束



//        //就餐结束去结账
//        System.out.println("您是否持有优惠券？如果有请输入对应的优惠卷类型A，B，C，如果没有请输入N！");
//        String type = scan.nextLine().toString();
//        cashier1.setOrder(order);
//        cashier1.setCouponType(type);
//
//        //通过优惠劵类型来结账
//        RealDiscount realDiscount = new RealDiscount(type);
////        System.out.printf("discount = "+realDiscount.getDiscount());
//
//        //结完账之后来推荐一个VIP办理
//        //先判断是不是VIP，然后再推荐
//        VIPCashierDecorator vipCashierDecorator = new VIPCashierDecorator(cashier1);
//        vipCashierDecorator.settleAccount();
















//test for StatePattern
        //初始时根据时间不同来让顾客的状态发生变化
        //感觉需要有一个更好的办法
        //顾客的点餐、等待、就餐等状态之间的变化需要的参数应当不是同一个
        //或者是同一个参数（时间），但如何传、由谁传递需要决定
//        Customer customer= new Customer();
//        customer.setTime(8);
//        customer.getState();
//        customer.setTime(9);
//        customer.getState();
//        customer.setTime(11);
//        customer.getState();
//        customer.setTime(21);
//        customer.getState();
//        customer.setTime(31);
//        customer.getState();
//        customer.setTime(41);
//        customer.getState();




//test for BridgePattern
        //注册不同的职工来调用同一个接口API的不同实体类
//        Employee waiter1 = new Waiter("waiter1",24,new FloorAirConditioner());
//        Employee manager = new Manager("waiter2",25,new HangingAirConditioner());
//
//        waiter1.changeTmp();
//        manager.changeTmp();


////test for CompositePattern
//        //注册的四名顾客
//        Customer customer1=new Customer("张先生", Gender.MALE,VIPType.VIP);
//        Customer customer2=new Customer("张女士", Gender.FEMALE,VIPType.VIP);
//        Customer customer3=new Customer("张先生", Gender.MALE,VIPType.NONVIP);
//        Customer customer4=new Customer("张女士",Gender.FEMALE,VIPType.NONVIP);
//
//        //通过是否为VIP将VIP顾客和非VIP顾客加入不同的List里面
//        //感觉需要更好的划分方法（或者应该有判断语句来自动划分顾客种类？
//        customer1.add(customer2);
//        customer3.add(customer4);
//
//        System.out.println(customer1);
//        System.out.println(customer3);
//
////test for ProxyPattern
//        MenuSource source=new ProxyMenuSource("pictureOfDish.jpg");
//        //资源文件需要从磁盘加载
//        source.show();
//        System.out.println(" ");
//        //资源文件不需要从磁盘加载
//        source.show();


//test for BuilderPattern
//        ComboBuilder comboBuilder1= new ConcreteComboBuilderA();
//        ComboBuilder comboBuilder2= new ConcreteComboBuilderB();
//        Director director1 =new Director(comboBuilder1);
//        Director director2 =new Director(comboBuilder2);
//        Combo comboA=director1.construct();
//        Combo comboB=director2.construct();


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


        //打折的测试
        //RealDiscount realDiscount = new RealDiscount("A");
        //System.out.printf("discount = "+realDiscount.getDiscount());

        //投诉处理的测试
//        Manager manager = Manager.getInstance();
//        Waiter waiter = new Waiter();
//
//        Complaint complaint = new Complaint(1, manager, waiter);
//        complaint.setCurHanlder();
//        complaint.getEmployee().settleComplaint();
//
//        Complaint complaint1 = new Complaint(3, manager, waiter);
//        complaint1.setCurHanlder();
//        complaint1.settleProblem();

        //结账处理的测试
//        Order order = new Order();
//        order.setPrice(100.0);
//        Cashier cashier = new Cashier(order, "N");
//
//        VIPCashierDecorator vipCashierDecorator = new VIPCashierDecorator(cashier);
//        vipCashierDecorator.settleAccount();


        //原型和备忘录模式的测试
//        Order order = new Order();
//        order.setPrice(100.0);
//
//        OrderClone orderClone = new OrderClone(order);
//
//        OrderClone orderClone1 = (OrderClone)orderClone.clone();
//        Memento memento = new Memento();
//        memento.addOrderClone(orderClone1);
//        //memento.getOrderClone(1);
//        int length = memento.getSize();
//        System.out.println(memento.getOrderClone(length-1).getPrice());



        //输出菜单测试
//        Menu menu = Menu.getInstance();
//        menu.showMenu();

        //观察者模式测试
//        Order order= new Order();
//        Employee waiter2 = new Waiter(24,new FloorAirConditioner(),order);
//        Employee cook2= new Cook(24,new FloorAirConditioner(),order);
//        order.setOrderState(0);
//        order.setOrderState(1);
//        //facade测试
//        List<Item> items=new ArrayList<>();
//        items.add(new Item("可乐",20.2));
//        items.add(new Item("雪碧",20.2));
//        items.add(new Item("酸梅汁",20.2));
//        items.add(new Item("百威啤酒",20.2));
//        order.setItemList(items);
//        ((Waiter) waiter2).getDrinkList(order);


//
//        int id = 1;
//        List<Item> itemList = new ArrayList<Item>();
//        itemList.add(new Item("汉堡", 22));
//        itemList.add(new Item("薯条", 12));
//        itemList.add(new Item("果汁", 18));
//        OrderDispatcher dispatcher = new OrderDispatcher();
//        Order order = new Order();
//        order.setID(id);
//        order.setItemList(itemList);
//        dispatcher.addOrder(order);
//        int n = 3;
//        while(n > 0){
//            n--;
//            id++;
//            Thread.sleep(10000L);
//            int number = (new Random().nextInt(4)) + 1;
//            List<Item> items = new ArrayList<Item>();
//            while(number-- != 0){
//                items.add(Menu.getInstance().getItem(new Random().nextInt(18)));
//            }
//            StringBuilder builder = new StringBuilder();
//            for (Item item : items) {
//                builder.append(item.getName()).append(" ");
//            }
//            System.out.println(id + " " + builder.toString());
//            dispatcher.addOrder(new Order(id, items));
//        }
//        while(true);



    }



}
