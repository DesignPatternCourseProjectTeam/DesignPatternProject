package edu.tongji.designpattern.CommonClass.Order;


import edu.tongji.designpattern.DevideByPattern.IteratorPattern.MyIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steve
 * @param <T> 元素类型
 * @description 拥有迭代器的元素集合对象 -- 抽象基类
 *
 */
public abstract class AbstractAggregate<T> {
    protected List<T> lst = new ArrayList<T>();
    protected int size = 0;

    /**
     * @description 添加元素
     * @param i 索引位置
     * @param elem 元素
     */
    public void add(int i,T elem){
        lst.add(i,elem);
    }

    /**
     * @description 从集合中删除元素
     * @param i 删除元素位置
     * @return T 删除的元素
     */
    public T remove(int i){
        if (lst.size() > 0) {
            return lst.remove(i);
        }
        System.out.println("ERROR:null array delete error");
        return null;
    }

    /**
     * @description 判断元素集合非空
     * @return boolean
     */
    public boolean isEmpty(){
        return lst.isEmpty();
    }

    /**
     * @description 获取迭代器对象
     * @implNote 修改集合对象会导致之前获取的迭代器的失效!
     * @return  MyIterator<T> 迭代器对象
     */
    public abstract MyIterator<T> createIterator();
}
