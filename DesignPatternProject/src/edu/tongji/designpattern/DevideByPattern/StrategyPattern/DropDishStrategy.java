package edu.tongji.designpattern.DevideByPattern.StrategyPattern;


import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.CommonClass.Other.Dish;

public class DropDishStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Dish dish, Order order) {
        if (order.removeDish(dish.getDishID())){
            System.out.println("drop dish"+dish.getDishID()+" success");
        }
        else
            System.out.println("dish not found");
        return order;
    }
}
