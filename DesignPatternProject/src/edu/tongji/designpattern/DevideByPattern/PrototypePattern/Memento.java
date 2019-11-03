package edu.tongji.designpattern.DevideByPattern.PrototypePattern;

/*
 * created by zhujitao
 * 2019/10/22
 * 记录菜单的类，使用了备忘录模式
 * */


import java.util.ArrayList;
import java.util.List;

public class Memento {

    //在备忘录中存储订单的列表
    private List<OrderClone> mementoList = new ArrayList<OrderClone>();

    //向列表内添加克隆订单的函数
    public boolean addOrderClone(OrderClone orderClone){
        boolean flag = false;
        //添加操作
        mementoList.add(orderClone);
        return flag;
    }

    //根据index获取备忘录中存储的订单的函数，最终会返回一个orderClone
    public OrderClone getOrderClone(int index){
        OrderClone orderClone = mementoList.get(index);
        return orderClone;
    }

    //返回列表的长度
    public int getSize(){
        return mementoList.size();
    }


}
