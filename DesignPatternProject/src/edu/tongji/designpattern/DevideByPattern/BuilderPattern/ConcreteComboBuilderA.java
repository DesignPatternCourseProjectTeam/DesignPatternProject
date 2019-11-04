package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @created by Cheng
 * 套餐建造类A: 继承自套餐建造类，是具体化的一个实例
 * 属性：有继承自父类的combo对象
 * 方法：具体实现建造功能
 */
public class ConcreteComboBuilderA extends ComboBuilder {

    //具体建造函数：建造第一个组件，以下函数依此类推
    @Override
    public void buildDishA() {
        combo.setDishA("炸鸡");
    }

    @Override
    public void buildDishB() {
        combo.setDishB("沙拉");

    }
    @Override
    public void buildDrink() {
        combo.setDrink("可乐");
    }

    @Override
    public void buildPrice() {
        combo.setPrice("40");
    }

    @Override
    public void buildNum(){ combo.setNum(1);}

    @Override
    public void buildItemList(){
        itemList = new ArrayList<>();
        itemList.add(new Item("炸鸡", 10));
        itemList.add(new Item("沙拉", 10));
        itemList.add(new Item("可乐", 10));
    }

    @Override
    public void setItemList(List<Item> itemList) {
        super.setItemList(itemList);
    }

    @Override
    public List<Item> getItemList() {
        return super.getItemList();
    }

    @Override
    public Double getPrice() {
        return 40.0;
    }
}
