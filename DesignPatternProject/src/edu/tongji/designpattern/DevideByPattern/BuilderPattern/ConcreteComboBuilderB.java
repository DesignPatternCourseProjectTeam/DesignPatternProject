package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;

import java.util.ArrayList;

/**
 * @created by Cheng
 * 区别于ConcreteComboBuilderA的另一个具体建造者
 */
public class ConcreteComboBuilderB extends ComboBuilder {

    //具体建造函数：建造第一个组件，以下函数依此类推
    @Override
    public void buildDishA() {
        combo.setDishA("蒸菜");
    }

    @Override
    public void buildDishB() {
        combo.setDishB("寿司");

    }
    @Override
    public void buildDrink() {
        combo.setDrink("雪碧");
    }

    @Override
    public void buildPrice() {
        combo.setPrice("41");
    }

    @Override
    public void buildNum(){ combo.setNum(2);}

    @Override
    public void buildItemList(){
        itemList = new ArrayList<>();
        itemList.add(new Item("蒸菜", 10));
        itemList.add(new Item("寿司", 10));
        itemList.add(new Item("雪碧", 10));
    }

    @Override
    public Double getPrice() {
        return 41.0;
    }

}
