package edu.tongji.designpattern.DevideByPattern.StrategyPattern;

import edu.tongji.designpattern.CommonClass.Other.*;
import edu.tongji.designpattern.CommonClass.Order.*;

public class AddDishStrategy implements OrderRecordingStrategy {
    @Override
    public Order execute(Dish dish, Order order) {
        order.addDish(dish);
        return order;
    }
}
