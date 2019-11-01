package edu.tongji.designpattern.ClassDesign.Business.DecoratorDemo;

/*
 * created by zhujitao
 * 2019/10/22
 * 收银员类的抽象装饰类
 * */

import edu.tongji.designpattern.ClassDesign.Person.Cashier;

public abstract class CashierDecorator {

    Cashier decoratedCashier;

    public CashierDecorator(Cashier decoratedCashier){
        this.decoratedCashier = decoratedCashier;
    }

    public boolean settleAccount(){
        boolean flag = false;
        //这里执行结账操作，结账成功返回true
        decoratedCashier.settleAccount();
        return flag;
    }

}
