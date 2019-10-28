package edu.tongji.designpattern.ClassDesign.Business.Facade;

public class DarkPlumJuiceOpener implements DrinkOpener {

    @Override
    public void Open() {
        System.out.println("class DarkPlumJuiceOpener：method Open：服务员为您打开了酸梅汁！");
    }
}
