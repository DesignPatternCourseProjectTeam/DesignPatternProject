package edu.tongji.designpattern.ClassDesign.Business.OrderRecording;

import edu.tongji.designpattern.ClassDesign.Business.Iterator.DishIterator;
import edu.tongji.designpattern.ClassDesign.Business.Iterator.OrderIterator;
import edu.tongji.designpattern.ClassDesign.Order.Order;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

public class OrderConfirmStrategy implements OrderRecordingStrategy{
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
