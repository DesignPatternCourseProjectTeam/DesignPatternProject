package edu.tongji.designpattern.DevideByPattern.StatePattern;

import edu.tongji.designpattern.CommonClass.Customer.Customer;

/**
 * @created by Cheng
 * 顾客状态类：一个返回顾客状态的抽象类
 *            状态：点单状态->等待状态->就餐状态->离开状态
 *            根据一个参数（目前设为时间）来得到顾客当前状态的信息
 *            基于状态模式，起始状态是点餐状态，即OrderState类
 */
public abstract  class CustomerState {
    public abstract void getState(Customer customer);
}
