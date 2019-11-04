package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;

import java.util.List;

/**
 * @created by Cheng
 * 套餐建造类：建造者模式的核心类
 *             通过继承这个类可以创建不同的建造者
 * 属性：一个protected类型的套餐类对象
 * 方法：建造者建造“组件”的函数和一个返回套餐的方法
 *       通过这些方法可以建造不同的组件（本例中即套餐）
 */
public abstract class ComboBuilder {

    protected Combo combo=new Combo();


    protected List<Item> itemList;

    protected Double price;



    /**
     * @description: 具体建造函数：建造第一个组件，以下函数依此类推
     * @Param:
     * @return:
     * @author: Cheng
     **/
    public abstract void buildDishA();

    public abstract void buildDishB();

    public abstract void buildDrink();

    public abstract void buildPrice();

    public abstract void buildNum();

    public abstract void buildItemList();

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /**
    * @description: 返回实现的套餐，返回类型为Combo（套餐）类型
     *              区别于以上的abstract类型的函数
    * @Param:
    * @return:
    * @author: Cheng
    **/
    public Combo getResult(){
        return combo;
    }

}
