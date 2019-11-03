package edu.tongji.designpattern.DevideByPattern.CommandPattern;



import edu.tongji.designpattern.CommonClass.Employee.Waiter;

public class CreateOrderCommand extends OrderPadCommand {
    public CreateOrderCommand(Waiter rec){
        super(rec);
    }
    @Override
    public void execute() {
        this.receiver.createOrderForCustomer();
    }
}
