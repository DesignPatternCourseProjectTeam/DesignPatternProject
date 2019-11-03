package edu.tongji.designpattern.DevideByPattern.CommandPattern;


import edu.tongji.designpattern.CommonClass.Employee.Waiter;

public class ConfirmOrderCommand extends OrderPadCommand {
    public ConfirmOrderCommand(Waiter rec){
        super(rec);

    }
    @Override
    public void execute() {
        this.receiver.confirmOrderForCustomer();
    }
}
