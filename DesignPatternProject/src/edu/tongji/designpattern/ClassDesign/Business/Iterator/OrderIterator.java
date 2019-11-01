package edu.tongji.designpattern.ClassDesign.Business.Iterator;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Order.OrderAggregate;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

import java.util.List;

public class OrderIterator implements MyIterator<Order> {

    private OrderAggregate agg = null;
    private List<Order> lst = null;
    private int position = 0;

    public OrderIterator(OrderAggregate agg, List<Order> lst){
        this.agg = agg;
        this.lst = lst;
    }

    @Override
    public boolean hasNext() {
        return position < (lst.size() - 1);
    }

    @Override
    public Order getNext() {
        if (position < lst.size()){
            return lst.get(position++);
        }
        System.out.println("out of bound");
        return null;
    }

    @Override
    public Order getCurrent() {
        if (lst.isEmpty() || (position>=lst.size()) || (position<0) ){
            return null;
        }
        else
            return lst.get(position);
    }

    @Override
    public void setPosition(int i) {
        if ( (i < lst.size() - 1) && (i>=0) ){
            position = i-1;
        }
        else {
            System.out.println("out of bound");
        }
    }

    public OrderAggregate getAggregate(){return this.agg;}

}
