package edu.tongji.designpattern.DevideByPattern.FacadePattern;

//啤酒开瓶器，实现饮料开瓶器接口
public class BeerOpener implements DrinkOpener {

    @Override
   /**
    * @author ruanby
    * @date 2019/11/2

    * @return null
    * @function 打印要开的饮料信息
   */
    public void Open() {
        System.out.println("class BeerOpener：method Open：服务员为您打开了百威啤酒！");
    }
}
