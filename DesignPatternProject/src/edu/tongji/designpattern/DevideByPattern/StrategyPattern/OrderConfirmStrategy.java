package edu.tongji.designpattern.DevideByPattern.StrategyPattern;


import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.CommonClass.Other.Dish;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.DishIterator;

public class OrderConfirmStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Dish dish, Order order) {
        DishIterator iter = (DishIterator) order.createIterator();
        while (iter.hasNext()){
            Dish item = iter.getNext();
            System.out.println("confirm dish "+item.getDishID());
        }
        order.setTypeToDetermined();
        return order;
    }
}
