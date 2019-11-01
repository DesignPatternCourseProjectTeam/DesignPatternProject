package edu.tongji.designpattern.ClassDesign.Business.ChainofResponsibilityDemo;

/*
 * created by zhujitao
 * 2019/10/22
 * 责任链模式里面的投诉类
 * */


import edu.tongji.designpattern.ClassDesign.Person.Employee;
import edu.tongji.designpattern.ClassDesign.Person.Manager;
import edu.tongji.designpattern.ClassDesign.Person.Waiter;

public class Complaint {

     Manager manager;
     Waiter waiter;

     Employee employee;

     public int level;

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
