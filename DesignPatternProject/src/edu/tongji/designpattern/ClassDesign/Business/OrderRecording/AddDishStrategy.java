package edu.tongji.designpattern.ClassDesign.Business.OrderRecording;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public class AddDishStrategy implements OrderRecordingStrategy{
    @Override
    public Order execute(Dish dish, Order order) {
        order.addDish(dish);
        return order;
    }
}
