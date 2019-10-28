package edu.tongji.designpattern.ClassDesign.Business.State;

import edu.tongji.designpattern.ClassDesign.Person.Customer;

//继承抽象类后根据一个参数来得到顾客是否已经离开的信息
public abstract  class CustomerState {
    public abstract void getState(Customer customer);
}
