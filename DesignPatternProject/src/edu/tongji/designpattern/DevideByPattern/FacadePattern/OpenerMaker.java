package edu.tongji.designpattern.DevideByPattern.FacadePattern;

//向客户提供了一个客户可以使用开饮料功能的接口
public class OpenerMaker {

    //定义各种饮料开瓶器实例
    private DrinkOpener beerOpener;
    private DrinkOpener cockOpener;
    private DrinkOpener spriteOpener;
    private DrinkOpener darkPlumJuiceOpener;

    /**
     * @author ruanby
     * @date  11/2
     * @return null
     * @function  这个接口的构造函数，初始化上面代码定义的饮料开瓶器对象
    */
    public OpenerMaker(){
        beerOpener = new BeerOpener();
        cockOpener = new CockOpener();
        spriteOpener = new SpriteOpener();
        darkPlumJuiceOpener = new DarkPlumJuiceOpener();
    }

    /**
     * @author ruanby
     * @date
     * @return null
     * @function 这里实现接口提供的方法，它们分别为打开啤酒，打开可乐，打开雪碧，打开酸梅汁
    */
    public void openBeer() {
        beerOpener.Open();
    }
    public void openCock() {
        cockOpener.Open();
    }
    public void openSprite() {
        spriteOpener.Open();
    }
    public void openDarkPlumJuice() {
        darkPlumJuiceOpener.Open();
    }

}
