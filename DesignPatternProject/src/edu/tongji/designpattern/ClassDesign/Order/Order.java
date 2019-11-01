package edu.tongji.designpattern.ClassDesign.Order;

import edu.tongji.designpattern.ClassDesign.Business.Iterator.DishIterator;
import edu.tongji.designpattern.ClassDesign.Business.Iterator.MyIterator;
import edu.tongji.designpattern.ClassDesign.Business.PrototypeMementoDemo.Item;
import edu.tongji.designpattern.ClassDesign.Person.Employee;
import edu.tongji.designpattern.ClassDesign.Tools.Dish;

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


    //下面是get和set方法
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getOrderID() {
        return orderID;
    }

    public Date getDate(){
        return date;
    }

    public OrderType getType(){
        return type;
    }

    public Integer getOrderState() {
        return orderState;
    }
    //加入notifyall函数：ruanbanyao
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
        notifyAllEmployees();
    }
    //ruan
    public void addEmploy(Employee e){
        employeeList.add(e);
    }
    private void notifyAllEmployees() {
        for (Employee employee : employeeList) {
            employee.update();
        }
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
