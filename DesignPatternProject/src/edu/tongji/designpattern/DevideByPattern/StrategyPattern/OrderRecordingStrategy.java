package edu.tongji.designpattern.DevideByPattern.StrategyPattern;

import edu.tongji.designpattern.CommonClass.Order.*;
import edu.tongji.designpattern.CommonClass.Other.Dish;


public interface OrderRecordingStrategy {
    Order execute(Dish dish, Order order);
}
