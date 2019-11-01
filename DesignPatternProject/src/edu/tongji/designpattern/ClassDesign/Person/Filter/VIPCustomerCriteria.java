package edu.tongji.designpattern.ClassDesign.Person.Filter;

import edu.tongji.designpattern.ClassDesign.Person.Customer;

import java.util.stream.Collectors;

public class VIPCustomerCriteria extends CustomerCriteria {
    @Override
    public void meetCriteria() {
        this.customerList = this.customerList.stream()
                .filter(p->p.isVIP())
                .collect(Collectors.toList());
    }

    @Override
    public boolean isMetCriteria(Customer customer) {
        this.meetCriteria();
        for (Customer item: this.customerList){
            if (item == customer)
                return true;
        }
        return false;
    }
}
