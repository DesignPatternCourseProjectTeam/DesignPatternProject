package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

/**
 * @created by Cheng
 * 指挥者类：调用建造者对象中的部件构造与装配方法完成复杂对象的创建
 *           在指挥者中不涉及具体套餐的信息
 * 属性：   一个ComboBuilder对象
 * 方法：   构造函数和construct()函数
 */
public class Director {
    private ComboBuilder comboBuilder;

    public Director(ComboBuilder comboBuilder){
        this.comboBuilder=comboBuilder;
    }

    /**
    * @description: 套餐构建与组装方法
    * @Param:
    * @return:
    * @author: Cheng
    **/
    public Combo construct(){
        //组件的具体构造过程
        System.out.println("套餐内容：");
        comboBuilder.buildDishA();
        comboBuilder.buildDishB();
        comboBuilder.buildDrink();
        comboBuilder.buildPrice();
        return comboBuilder.getResult();
    }

}
