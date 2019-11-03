package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

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
        combo.setDishA("蒸鱼");
    }

    @Override
    public void buildDishB() {
        combo.setDishB("生菜沙拉");

    }
    @Override
    public void buildDrink() {
        combo.setDrink("可乐");
    }

    @Override
    public void buildPrice() {
        combo.setPrice("40");
    }
}
