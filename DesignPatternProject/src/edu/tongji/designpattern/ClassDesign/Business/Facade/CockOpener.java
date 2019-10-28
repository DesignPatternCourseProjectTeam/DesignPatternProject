package edu.tongji.designpattern.ClassDesign.Business.Facade;

public class CockOpener implements DrinkOpener {

    @Override
    public void Open() {
        System.out.println("class CockOpener：method Open：服务员为您打开了可乐！");
    }
}
