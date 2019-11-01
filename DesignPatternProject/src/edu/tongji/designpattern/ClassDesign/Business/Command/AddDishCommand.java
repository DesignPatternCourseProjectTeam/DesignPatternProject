package edu.tongji.designpattern.ClassDesign.Business.Command;

import edu.tongji.designpattern.ClassDesign.Person.Waiter;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

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
