package edu.tongji.designpattern.ClassDesign.Business.Command;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Person.Waiter;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public abstract class OrderPadCommand {
    protected Waiter receiver = null;
    protected Order order = null;
    protected Dish dish = null;

    public OrderPadCommand(Waiter rec){
        this.receiver = rec;
    }

    public abstract void execute();
}
