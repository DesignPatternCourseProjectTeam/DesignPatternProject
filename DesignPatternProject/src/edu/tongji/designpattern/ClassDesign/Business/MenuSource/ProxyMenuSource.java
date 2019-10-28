package edu.tongji.designpattern.ClassDesign.Business.MenuSource;

public class ProxyMenuSource implements MenuSource {
    private RealMenuSource realMenuSource;
    private String source;
    public ProxyMenuSource(String source){
        this.source=source;
    }
    @Override
    public void show() {
        if(realMenuSource==null){
            realMenuSource=new RealMenuSource(source);
        }
        realMenuSource.show();
    }
}
