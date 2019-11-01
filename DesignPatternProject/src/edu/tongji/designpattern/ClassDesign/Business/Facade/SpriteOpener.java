package edu.tongji.designpattern.ClassDesign.Business.Facade;

public class SpriteOpener implements DrinkOpener {

    @Override
    public void Open() {
        System.out.println("class SpriteOpener：method Open：服务员为您打开了雪碧！");
    }
}
