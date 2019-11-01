package edu.tongji.designpattern.ClassDesign.Order;

import edu.tongji.designpattern.ClassDesign.Business.Iterator.DishIterator;
import edu.tongji.designpattern.ClassDesign.Business.Iterator.MyIterator;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends AbstractAggregate<Dish> {
    private String orderID;
    private Date date;
    private OrderType type = OrderType.UNDETERMINED;
    private List<Dish> dishes = new ArrayList<>();



    public String getOrderID() {
        return orderID;
    }

    public Date getDate(){
        return date;
    }

    public OrderType getType(){
        return type;
    }

    /*
        convert @undetermined-order into @order
     */
    public void setTypeToDetermined(){
        this.type = OrderType.DETERMINED;
    }


    /*
        add new dish to the dish array
     */
    public void addDish(Dish dsh){
        dishes.add(dsh);
    }

    /*
        remove dish by dishID
     */
    public boolean removeDish(String dishID){
        for (Dish dsh:dishes){
            if (dishID == dsh.getDishID()){
                return dishes.remove(dsh);
            }
        }
        return false;
    }

    public List<Dish> getDishes(){return this.dishes;}


    @Override
    public MyIterator<Dish> createIterator() {
        return new DishIterator(this,dishes);
    }
}
