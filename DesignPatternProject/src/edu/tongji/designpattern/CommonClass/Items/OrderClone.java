package edu.tongji.designpattern.CommonClass.Items;

/*
 * created by zhujitao
 * 2019/10/22
 * 原型模式里面的例子
 * */



import java.util.ArrayList;
import java.util.List;

public class OrderClone implements Cloneable{

    private List<Item> itemList = new ArrayList<Item>();
    private double price = 0.0;

    //构造函数，传入的参数是Order，目的是将Order里面需要记录的数据存入OrderClone中
//    public OrderClone(Order order){
//        this.itemList = order.getItemList();
//        this.price = order.getPrice();
//    }

    //返回OrderColne的对象，将其存入备忘录中，方便记录
    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


    //下面是get和set方法
    public List<Item> getItemList() {
        return itemList;
    }

    public double getPrice() {
        return price;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
