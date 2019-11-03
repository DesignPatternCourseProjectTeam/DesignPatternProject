package edu.tongji.designpattern.DevideByPattern.StatePattern;

import edu.tongji.designpattern.CommonClass.Customer.Customer;

/**
 * @created by Cheng
 * 结账状态类：顾客的结账状态类
 */
public class CheckOutState extends CustomerState{

    /**
    * @description: 判断顾客是否处与结账状态
     *              如果是，输出顾客状态，如果不是，自动进入下一个状态就餐状态并输出状态
    * @Param: Customer customer
    * @return:
    * @autho: Cheng
    **/
    @Override
    public void getState(Customer customer) {
        if(customer.getTime()<40){
            System.out.println("顾客现在状态是结账状态");
        }else{
            //跳转进入离开状态
            customer.setState(new LeaveState());
            customer.getState();
        }


    }
}
