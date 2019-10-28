package edu.tongji.designpattern.ClassDesign.Business.MenuSource;

public class RealMenuSource implements MenuSource {
    private String source;
    public RealMenuSource(String source){
        this.source=source;
        loadFromDisk(source);
    }
    @Override
    public void show() {
        System.out.println("Show"+source);
    }

    private void loadFromDisk(String source){
        System.out.println("Loading"+source);
    }
}
