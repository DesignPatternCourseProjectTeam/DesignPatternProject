package edu.tongji.designpattern.DevideByPattern.CommandPattern;


import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.CommonClass.Other.Dish;

public abstract class OrderPadCommand {
    protected Waiter receiver = null;
    protected Order order = null;
    protected Dish dish = null;

    public OrderPadCommand(Waiter rec){
        this.receiver = rec;
    }

    public abstract void execute();
}
