package edu.tongji.designpattern.DevideByPattern.ChainofResponsibilityPattern;

/*
 * created by zhujitao
 * 2019/10/22
 * 责任链模式里面的投诉类
 * */


import edu.tongji.designpattern.CommonClass.Employee.Employee;
import edu.tongji.designpattern.CommonClass.Employee.Manager;
import edu.tongji.designpattern.CommonClass.Employee.Waiter;

public class Complaint {

     //处理投诉的对象
     Manager manager;
     Waiter waiter;
     Employee employee;

     //定义投诉等级的级别
     public int level;

     //构造函数
     public Complaint(int level, Manager manager, Waiter waiter){
         this.level = level;
         this.manager  =manager;
         this.waiter = waiter;
     }

     //责任链模式，将投诉通过类型进行分析，如果是低级投诉就
     //使用服务员来解决，高级投诉使用经理来解决
     //假设投诉登记为1时服务员前来处理，否则的话是由经理来处理
     //最终默认投诉会被处理
     public void setCurHanlder(){
         if (level==1){
             employee = waiter;
         }else {
             employee = manager;
         }
     }

     //get and set方法
     public void settleProblem(){
         employee.settleComplaint();
     }

    public Employee getEmployee() {
        return employee;
    }

    public int getLevel() {
        return level;
    }

    public Manager getManager() {
        return manager;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
