package edu.tongji.designpattern.DevideByPattern.StatePattern;

import edu.tongji.designpattern.CommonClass.Customer.Customer;

/**
 * @created by Cheng
 * 就餐状态类：顾客的就餐状态类
 */
public class EatState extends CustomerState {

    /**
     * @description: 判断顾客是否处与就餐状态
     *              如果是，输出顾客状态，如果不是，自动进入下一个状态就餐状态并输出状态
     * @Param: Customer customer
     * @return:
     * @autho: Cheng
     **/
    @Override
    public void getState(Customer customer) {
        if(customer.getTime()<30){
            System.out.println("顾客现在状态是就餐状态");
        }else{
            //跳转进入结账状态
            customer.setState(new CheckOutState());
            customer.getState();
        }


    }
}
