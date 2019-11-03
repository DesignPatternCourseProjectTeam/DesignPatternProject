package edu.tongji.designpattern.DevideByPattern.MediatorPattern;

import edu.tongji.designpattern.CommonClass.Other.*;
import edu.tongji.designpattern.CommonClass.Employee.Employee;
import edu.tongji.designpattern.CommonClass.Employee.*;

import java.util.ArrayList;
import java.util.List;

public class InterPhoneChannel {
    private Boolean status = false;
    private List<? extends Employee> onlineEmployees = new ArrayList<Employee>();
    public static InterPhoneChannel instance = null;

    /*
        singleton
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


    public static InterPhoneChannel getInstance(List<? extends Employee> eArray){
        if (instance == null){
            instance = new InterPhoneChannel(eArray);
        }
        return instance;
    }

    /*
        notify objects
     */
    public Boolean notify(Employee sender, String message, BroadcastType bctype){
        if (sender == null || this.status == false){
            System.out.println("notify failure");
            return false;
        }
        if (bctype == BroadcastType.ALL_EMPLOYEE){
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
