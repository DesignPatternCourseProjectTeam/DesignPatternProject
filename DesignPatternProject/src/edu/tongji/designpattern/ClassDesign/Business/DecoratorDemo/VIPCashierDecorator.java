package edu.tongji.designpattern.ClassDesign.Business.DecoratorDemo;

/*
 * created by zhujitao
 * 2019/10/22
 * 收银员类的装饰类的具体的类
 * */

import edu.tongji.designpattern.ClassDesign.Person.Cashier;

import java.util.Scanner;

public class VIPCashierDecorator extends CashierDecorator {

    //初始化函数
    public VIPCashierDecorator(Cashier decoratedCashier){
        super(decoratedCashier);
    }

    @Override
    public boolean settleAccount() {
        boolean flag = false;
        flag = super.settleAccount();
        //在正常结账之后进行VIP推荐服务
        VIPApplication();
        return flag;
    }

    public boolean VIPApplication(){
        boolean flag = false;
        //在下面询问顾客是否办理VIP，然后执行对应的操作
        System.out.println("您现在还不是VIP用户，需要为您办理VIP专属卡吗？");
        String answer = "";
        Scanner input =new Scanner(System.in);
        answer = input.next();
        if(answer.equals("Yes")){
            System.out.println("感谢您的信任，您现在已经是本店的VIP贵宾了，以后请多多支持！");
        }else {
            System.out.println("期待您对本店的进一步支持！");
        }

        return flag;
    }

}
