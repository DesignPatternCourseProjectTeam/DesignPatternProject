package edu.tongji.designpattern.CommonClass.Order;


import edu.tongji.designpattern.CommonClass.Employee.Employee;
import edu.tongji.designpattern.CommonClass.Items.Item;
import edu.tongji.designpattern.CommonClass.Other.Dish;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.DishIterator;
import edu.tongji.designpattern.DevideByPattern.IteratorPattern.MyIterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends AbstractAggregate<Dish> {
    private String orderID;
    private Date date;
    private OrderType type = OrderType.UNDETERMINED;
    private List<Dish> dishes = new ArrayList<>();
    private List<Item> itemList = new ArrayList<Item>();
    private List<Employee> employeeList = new ArrayList<Employee>();
    private double price = 0.0;
    private Integer orderState;


    //下面是get和set方法，zhujitao
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @author ruanby
     * @date 11/2
     * @return List<Item>
     * @function 返回当前订单中的菜品和饮品list
     */
    public List<Item> getItemList() {
        return itemList;
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    /**
     * @author  steve
     * @return orderID 当前的 order ID
     */
    public String getOrderID() {
        return orderID;
    }

    public Date getDate(){
        return date;
    }

    public OrderType getType(){
        return type;
    }

    /**
     * @author ruanby
     * @date 11/2
     * @return Integer
     * @function 返回订单的状态，新订单创建或者当前订单完成，用0/1表示
     */
    public Integer getOrderState() {
        return orderState;
    }



    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 订单状态发生变化后，通知所有的职工，更新他们的工作状态
     */
    private void notifyAllEmployees() {
        for (Employee employee : employeeList) {
            employee.update();
        }
    }


    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 向要通知的职工list中添加职工对象
     */
    public void addEmploy(Employee e){
        employeeList.add(e);
    }


    /**
     * @author ruanby
     * @date 11/2
     * @return null
     * @function 设置订单状态
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
        notifyAllEmployees();
    }


    /**
     * @author steve
     * @description set 目前的 Order 变成 DETERMINED
     */
    public void setTypeToDetermined(){
        this.type = OrderType.DETERMINED;
    }


    /**
     * @author steve
     * @param dsh 添加的菜
     */
    public void addDish(Dish dsh){
        dishes.add(dsh);
    }

    /*
        remove dish by dishID
     */

    /**
     * @author steve
     * @param dishID 删除的 dishID
     * @return boolean
     */
    public boolean removeDish(String dishID){
        for (Dish dsh:dishes){
            if (dishID == dsh.getDishID()){
                return dishes.remove(dsh);
            }
        }
        return false;
    }

    public List<Dish> getDishes(){
        return this.dishes;
    }


    @Override
    public MyIterator<Dish> createIterator() {
        return new DishIterator(this,dishes);
    }
}
