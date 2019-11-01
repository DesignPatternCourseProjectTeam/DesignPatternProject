package edu.tongji.designpattern.ClassDesign.Order;

import edu.tongji.designpattern.ClassDesign.Business.Iterator.MyIterator;
import edu.tongji.designpattern.ClassDesign.Business.Iterator.OrderIterator;

public class OrderAggregate extends AbstractAggregate<Order> {

    @Override
    public MyIterator createIterator() {
        return new OrderIterator(this, lst);
    }
}
