package edu.tongji.designpattern.DevideByPattern.IteratorPattern;

public interface MyIterator<T> {
    boolean hasNext();
    T getNext();
    T getCurrent();
    void setPosition(int i);
}
