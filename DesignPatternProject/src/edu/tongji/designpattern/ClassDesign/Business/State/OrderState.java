package edu.tongji.designpattern.ClassDesign.Business.State;

import edu.tongji.designpattern.ClassDesign.Person.Customer;
import edu.tongji.designpattern.ClassDesign.Person.Waiter;

public class OrderState extends CustomerState{
    @Override
    public void getState(Customer customer) {
        if(customer.getTime()<10){
            System.out.println("顾客现在状态是点单状态");
        }else{
            customer.setState(new WaitState());
            customer.getState();
        }

    }
}
