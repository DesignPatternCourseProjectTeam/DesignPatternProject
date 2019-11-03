package edu.tongji.designpattern.DevideByPattern.MediatorPattern;

import edu.tongji.designpattern.CommonClass.Other.*;
import edu.tongji.designpattern.CommonClass.Employee.Employee;
import edu.tongji.designpattern.CommonClass.Employee.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steve
 * @description singleton 对象，获取公共信道
 */
public class InterPhoneChannel {
    private Boolean status = false;
    private List<? extends Employee> onlineEmployees = new ArrayList<Employee>();
    public static InterPhoneChannel instance = null;

    /**
     * @description private constructor
     * @param eArray
     */
    private InterPhoneChannel(List<? extends Employee> eArray){
        try{
            this.onlineEmployees = eArray;
            if (eArray.isEmpty())
                throw new Exception("empty array");
            for (Employee e:eArray){
                if (!e.setChannel(this)){
                    throw new Exception("set channel failure");
                }
            }
        }catch (Exception e){
            System.out.println(e);
            return;
        }
        this.status = true;
    }


    /**
     * @descriiption get singleton object
     * @param eArray
     * @return
     */
    public static InterPhoneChannel getInstance(List<? extends Employee> eArray){
        if (instance == null){
            instance = new InterPhoneChannel(eArray);
        }
        return instance;
    }

    /**
     * @author steve
     * @description 发送消息
     * @param sender 发送者
     * @param message 消息
     * @param bctype 广播类型
     * @return boolean 发送结果
     */
    public Boolean notify(Employee sender, String message, BroadcastType bctype){
        if (sender == null || this.status == false){
            System.out.println("notify failure");
            return false;
        }
        if (bctype == BroadcastType.ALL_WAITER){
            for (Employee e:this.onlineEmployees){
                if (e.getTitle() == EmployeeTitle.WAITER){
                    /// pass message
                    e.getMessage(message);
                }
            }
        }
        else if (bctype == BroadcastType.MANAGER_REPORT){
            for (Employee e:this.onlineEmployees){
                if (e.getTitle() == EmployeeTitle.MANAGER){
                    /// pass message
                    e.getMessage(message);
                    return true;
                }
            }
            return false;
        }
        else if (bctype == BroadcastType.ALL){
            for (Employee e:this.onlineEmployees){
                /// pass message
                e.getMessage(message);
            }
        }
        return true;
    }
}
