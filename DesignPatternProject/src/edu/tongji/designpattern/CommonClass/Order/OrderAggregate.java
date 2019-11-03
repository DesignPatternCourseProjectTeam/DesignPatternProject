package edu.tongji.designpattern.CommonClass.Order;


import edu.tongji.designpattern.DevideByPattern.IteratorPattern.MyIterator;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.OrderIterator;

/**
 * @author steve
 * @descritpion 所有 order 的集合类，可使用迭代器
 */
public class OrderAggregate extends AbstractAggregate<Order> {

    @Override
    public MyIterator createIterator() {
        return new OrderIterator(this, lst);
    }
}
