package edu.tongji.designpattern.DevideByPattern.StatePattern;

import edu.tongji.designpattern.CommonClass.Customer.Customer;

/**
 * @created by Cheng
 * 离开状态类：顾客的离开状态类
 */
public class LeaveState extends CustomerState {

    /**
     * @description: 输出顾客状态为离开状态，因为这是最后一个状态，不用跳转
     * @Param: Customer customer
     * @return:
     * @autho: Cheng
     **/
    @Override
    public void getState(Customer customer) {
        System.out.println("顾客已离开");
    }
}
