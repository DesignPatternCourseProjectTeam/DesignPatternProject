package edu.tongji.designpattern.CommonClass.Order;


import edu.tongji.designpattern.DevideByPattern.IteratorPattern.MyIterator;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.OrderIterator;

public class OrderAggregate extends AbstractAggregate<Order> {

    @Override
    public MyIterator createIterator() {
        return new OrderIterator(this, lst);
    }
}
