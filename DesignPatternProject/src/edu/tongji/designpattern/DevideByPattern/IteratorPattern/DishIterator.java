package edu.tongji.designpattern.DevideByPattern.IteratorPattern;



import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.CommonClass.Other.Dish;

import java.util.List;

public class DishIterator implements MyIterator<Dish> {

    private Order order = null;
    private List<Dish> lst = null;
    private int position = 0;

    public DishIterator(Order order, List<Dish> dishes){
        this.order = order;
        this.lst = dishes;
    }

    @Override
    public boolean hasNext() {
        return position <= (lst.size() - 1);
    }

    @Override
    public Dish getNext() {
        if (position < lst.size()){
            return lst.get(position++);
        }
        System.out.println("out of bound");
        return null;
    }

    @Override
    public void setPosition(int i) {
        if ( (i <= lst.size() - 1) && (i>=0) ){
            position = i;
        }
        else {
            System.out.println("out of bound");
        }
    }

    public Order getOrder(){return this.order;}

    @Override
    public Dish getCurrent() {
        if (lst.isEmpty() || (position>=lst.size()) || (position<0) ){
            return null;
        }
        else
            return lst.get(position);
    }
}
