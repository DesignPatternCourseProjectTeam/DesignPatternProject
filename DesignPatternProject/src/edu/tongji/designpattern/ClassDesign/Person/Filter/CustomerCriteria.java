package edu.tongji.designpattern.ClassDesign.Person.Filter;

import edu.tongji.designpattern.ClassDesign.Person.Customer;

import java.util.List;

public abstract class CustomerCriteria {
    protected List<Customer> customerList = null;
    public abstract void meetCriteria();
    public abstract boolean isMetCriteria(Customer customer);
}
