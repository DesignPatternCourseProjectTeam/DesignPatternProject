package edu.tongji.designpattern.DevideByPattern.StrategyPattern;


import edu.tongji.designpattern.CommonClass.Order.Order;
import edu.tongji.designpattern.CommonClass.Other.Dish;

public class OrderCreateStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Dish dish, Order order) {
        return new Order();
    }
}
