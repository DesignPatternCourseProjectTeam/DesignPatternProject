package edu.tongji.designpattern.ClassDesign.Business.Facade;

public class FacadeDemo {
    public static void main(String[] args) {
        OpenerMaker openerMaker=new OpenerMaker();
        openerMaker .openBeer() ;
        openerMaker .openCock() ;
        openerMaker .openDarkPlumJuice() ;
        openerMaker .openSprite() ;
    }


}
