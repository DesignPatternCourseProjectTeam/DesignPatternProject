package edu.tongji.designpattern.ClassDesign.Business.State;

import edu.tongji.designpattern.ClassDesign.Person.Customer;

public class CheckOutState extends CustomerState{
    @Override
    public void getState(Customer customer) {
        if(customer.getTime()<40){
            System.out.println("顾客现在状态是结账状态");
        }else{
            customer.setState(new LeaveState());
            customer.getState();
        }


    }
}
