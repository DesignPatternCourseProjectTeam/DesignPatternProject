package edu.tongji.designpattern.DevideByPattern.CommandPattern;


import edu.tongji.designpattern.CommonClass.Employee.Waiter;
import edu.tongji.designpattern.CommonClass.Other.Dish;

public class AddDishCommand extends OrderPadCommand {

    public AddDishCommand(Waiter rec, Dish dish){
        super(rec);
        this.dish = dish;
    }

    @Override
    public void execute() {
        this.receiver.addDishForCustomer(this.dish);
    }
}
