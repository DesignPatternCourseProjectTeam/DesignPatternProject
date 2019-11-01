package edu.tongji.designpattern.ClassDesign.Business.Command;

import edu.tongji.designpattern.ClassDesign.Business.OrderRecording.OrderCreateStrategy;
import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Person.Waiter;

public class CreateOrderCommand extends OrderPadCommand{
    public CreateOrderCommand(Waiter rec){
        super(rec);
    }
    @Override
    public void execute() {
        this.receiver.createOrderForCustomer();
    }
}
