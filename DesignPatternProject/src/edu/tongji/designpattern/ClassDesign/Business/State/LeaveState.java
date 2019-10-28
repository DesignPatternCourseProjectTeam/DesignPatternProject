package edu.tongji.designpattern.ClassDesign.Business.State;

import edu.tongji.designpattern.ClassDesign.Person.Customer;

public class LeaveState extends CustomerState {
    @Override
    public void getState(Customer customer) {
        System.out.println("顾客已离开");
    }
}
