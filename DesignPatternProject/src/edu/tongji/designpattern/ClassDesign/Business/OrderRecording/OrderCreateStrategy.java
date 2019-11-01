package edu.tongji.designpattern.ClassDesign.Business.OrderRecording;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public class OrderCreateStrategy implements OrderRecordingStrategy{
    @Override
    public Order execute(Dish dish, Order order) {
        return new Order();
    }
}
