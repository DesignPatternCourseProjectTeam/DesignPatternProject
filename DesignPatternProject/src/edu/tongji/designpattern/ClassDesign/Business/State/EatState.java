package edu.tongji.designpattern.ClassDesign.Business.State;

import edu.tongji.designpattern.ClassDesign.Person.Customer;

public class EatState extends CustomerState {
    @Override
    public void getState(Customer customer) {
        if(customer.getTime()<30){
            System.out.println("顾客现在状态是就餐状态");
        }else{
            customer.setState(new CheckOutState());
            customer.getState();
        }


    }
}
