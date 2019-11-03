package edu.tongji.designpattern.DevideByPattern.StatePattern;

import edu.tongji.designpattern.CommonClass.Customer.Customer;

/**
 * @created by Cheng
 * 点单状态类：顾客的点单状态类
 */
public class OrderState extends CustomerState{

    /**
     * @description: 判断顾客是否处与点单状态
     *               如果是，输出顾客状态，如果不是，自动进入下一个状态就餐状态并输出状态
     * @Param: Customer customer
     * @return:
     * @autho: Cheng
     **/
    @Override
    public void getState(Customer customer) {
        if(customer.getTime()<10){
            System.out.println("顾客现在状态是点单状态");
        }else{
            //跳转进入等待状态
            customer.setState(new WaitState());
            customer.getState();
        }

    }
}
