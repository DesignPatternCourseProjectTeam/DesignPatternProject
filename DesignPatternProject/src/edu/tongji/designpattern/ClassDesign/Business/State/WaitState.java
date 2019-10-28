package edu.tongji.designpattern.ClassDesign.Business.State;

import edu.tongji.designpattern.ClassDesign.Person.Customer;

public class WaitState extends CustomerState{
    @Override
    public void getState(Customer customer) {
        if(customer.getTime()<20){
            System.out.println("顾客现在状态是等待状态");
        }else{
            customer.setState(new EatState());
            customer.getState();
        }


    }
}
