package edu.tongji.designpattern.ClassDesign.Business.PrototypeMementoDemo;/*
 * created by zhujitao
 * 2019/10/25
 * 代替food的item
 * */

public class Item {

    private String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }



    //下面是get和set方法
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

}
