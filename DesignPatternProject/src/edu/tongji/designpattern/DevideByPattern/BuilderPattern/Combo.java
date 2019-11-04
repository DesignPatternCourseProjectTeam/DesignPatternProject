package edu.tongji.designpattern.DevideByPattern.BuilderPattern;

import edu.tongji.designpattern.CommonClass.Items.Item;

import java.util.List;

/**
 *   @created by Cheng
 *   套餐类：用于建造者模式
 *   属性：表示一个套餐的“组件”，该套餐由四种组件组成
 *   方法：用于描述组件的性质
 */
public class Combo {

    private Integer Num;
    private String dishA;
    private String dishB;
    private String drink;
    private String price;
    private List<Item> itemList;

    /**
    * @description: “组件”信息描述函数，用来描述组件信息或性质
     *               下面几个函数性质相同
    * @Param: String dishA
    * @return:
    * @author: Cheng
    **/
    public void setDishA(String dishA) {
        System.out.println("热菜："+dishA+" ");
    }

    public void setDishB(String dishB) {
        System.out.println("冷菜："+dishB+" ");
    }

    public void setDrink(String drink) {
        System.out.println("饮料："+drink+" ");
    }

    public void setPrice(String price){
        System.out.println("总价："+price+" ");
    }

    public void setNum(Integer num) {
        System.out.println("编号："+num+" ");
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
