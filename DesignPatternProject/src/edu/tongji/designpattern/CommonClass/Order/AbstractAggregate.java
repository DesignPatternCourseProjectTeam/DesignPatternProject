package edu.tongji.designpattern.CommonClass.Order;


import edu.tongji.designpattern.DevideByPattern.IteratorPattern.MyIterator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAggregate<T> {
    protected List<T> lst = new ArrayList<T>();
    protected int size = 0;

    public void add(int i,T elem){
        lst.add(i,elem);
    }

    public T remove(int i){
        if (lst.size() > 0) {
            return lst.remove(i);
        }
        return null;
    }

    public boolean isEmpty(){
        return lst.isEmpty();
    }

    public abstract MyIterator<T> createIterator();
}
