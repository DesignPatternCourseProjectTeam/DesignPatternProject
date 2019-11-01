package edu.tongji.designpattern.ClassDesign.Business.Iterator;

import java.util.*;

public interface MyIterator<T> {
    boolean hasNext();
    T getNext();
    T getCurrent();
    void setPosition(int i);
}
