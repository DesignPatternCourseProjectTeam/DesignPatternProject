package edu.tongji.designpattern.ClassDesign.Business.PrototypeMementoDemo;

/*
 * created by zhujitao
 * 2019/10/22
 * 使用单例模式去创建一个类
 * */


import java.util.ArrayList;
import java.util.List;

public class Memento {

    private List<OrderClone> mementoList = new ArrayList<OrderClone>();


    public boolean addOrderClone(OrderClone orderClone){
        boolean flag = false;
        //添加操作
        mementoList.add(orderClone);
        return flag;
    }

    public OrderClone getOrderClone(int index){
        OrderClone orderClone = mementoList.get(index);
        return orderClone;
    }

    public int getSize(){
        return mementoList.size();
    }


}
