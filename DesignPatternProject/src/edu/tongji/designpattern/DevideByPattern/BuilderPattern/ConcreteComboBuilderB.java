package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

/**
 * @created by Cheng
 * 区别于ConcreteComboBuilderA的另一个具体建造者
 */
public class ConcreteComboBuilderB extends ComboBuilder{

    //具体建造函数：建造第一个组件，以下函数依此类推
    @Override
    public void buildDishA() {
        combo.setDishA("蒸肉");
    }

    @Override
    public void buildDishB() {
        combo.setDishB("番茄沙拉");

    }
    @Override
    public void buildDrink() {
        combo.setDrink("雪碧");
    }

    @Override
    public void buildPrice() {
        combo.setPrice("41");
    }
}
