package edu.tongji.designpattern.ClassDesign.Business.Facade;

public class OpenerMaker {
    private DrinkOpener beerOpener;
    private DrinkOpener cockOpener;
    private DrinkOpener spriteOpener;
    private DrinkOpener darkPlumJuiceOpener;
    public OpenerMaker(){
        beerOpener = new BeerOpener();
        cockOpener = new CockOpener();
        spriteOpener = new SpriteOpener();
        darkPlumJuiceOpener = new DarkPlumJuiceOpener();
    }
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
