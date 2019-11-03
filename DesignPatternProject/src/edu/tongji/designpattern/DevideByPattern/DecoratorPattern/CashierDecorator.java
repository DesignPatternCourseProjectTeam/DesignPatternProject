package edu.tongji.designpattern.DevideByPattern.DecoratorPattern;

/*
 * created by zhujitao
 * 2019/10/22
 * 收银员类的抽象装饰类
 * */


import edu.tongji.designpattern.CommonClass.Employee.Cashier;

public abstract class CashierDecorator {

    //被装饰过的收银员对象
    Cashier decoratedCashier;

    public CashierDecorator(Cashier decoratedCashier){
        this.decoratedCashier = decoratedCashier;
    }

    //执行收银动作的函数，使用了装饰器模式
    public boolean settleAccount(){
        boolean flag = false;
        //这里执行结账操作，结账成功返回true
        decoratedCashier.settleAccount();
        return flag;
    }

}
