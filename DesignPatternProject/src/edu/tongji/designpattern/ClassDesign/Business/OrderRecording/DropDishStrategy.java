package edu.tongji.designpattern.ClassDesign.Business.OrderRecording;

import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public class DropDishStrategy implements OrderRecordingStrategy{
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
