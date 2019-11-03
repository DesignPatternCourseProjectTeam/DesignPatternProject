package edu.tongji.designpattern.DevideByPattern.CommandPattern;


import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Other.Dish;

public class DropDishCommand extends OrderPadCommand {
    public DropDishCommand(Waiter rec, Dish dish){
        super(rec);
        this.dish = dish;
    }
    @Override
    public void execute() {
        this.receiver.dropDishForCustomer(this.dish);
    }
}
