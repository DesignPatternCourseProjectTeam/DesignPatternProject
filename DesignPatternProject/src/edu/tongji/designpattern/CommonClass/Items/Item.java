package edu.tongji.designpattern.CommonClass.Items;

public class Item {
    private String dishID;
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

    public String getDishID(){return this.dishID;}

//    private String name;
//    private Integer price;
//    private String category;
//
//
//    public void setName(String name){
//        this.name=name;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
}
