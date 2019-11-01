package edu.tongji.designpattern.ClassDesign.Business.Command;

import edu.tongji.designpattern.ClassDesign.Person.Waiter;

public class ConfirmOrderCommand extends OrderPadCommand{
    public ConfirmOrderCommand(Waiter rec){
        super(rec);

    }
    @Override
    public void execute() {
        this.receiver.confirmOrderForCustomer();
    }
}
