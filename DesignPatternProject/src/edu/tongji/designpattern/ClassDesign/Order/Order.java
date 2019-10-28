package edu.tongji.designpattern.ClassDesign.Order;

import edu.tongji.designpattern.ClassDesign.Business.PrototypeMementoDemo.Item;
import edu.tongji.designpattern.ClassDesign.Person.Employee;

import java.util.ArrayList;
import java.util.List;

public class Order extends AbstractOrder {

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

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

}
