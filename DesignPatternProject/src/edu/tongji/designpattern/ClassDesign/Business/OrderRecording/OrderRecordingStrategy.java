package edu.tongji.designpattern.ClassDesign.Business.OrderRecording;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public interface OrderRecordingStrategy {
    Order execute(Dish dish, Order order);
}
