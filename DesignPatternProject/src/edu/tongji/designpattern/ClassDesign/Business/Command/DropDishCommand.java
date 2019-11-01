package edu.tongji.designpattern.ClassDesign.Business.Command;

import edu.tongji.designpattern.ClassDesign.Person.Waiter;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public class DropDishCommand extends OrderPadCommand{
    public DropDishCommand(Waiter rec, Dish dish){
        super(rec);
        this.dish = dish;
    }
    @Override
    public void execute() {
        this.receiver.dropDishForCustomer(this.dish);
    }
}
