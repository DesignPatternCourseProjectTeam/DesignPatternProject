package edu.tongji.designpattern.DevideByPattern.ProxyPattern;

/**
 * @created by Cheng
 * 代理资源类：用一个远程代理类来代替RealMenuSource来加载资源
 *             减少了RealMenuSource对象加载占用的内存
 *       属性: RealMenuSource对象以及资源文件source
 *       方法: 资源显示函数，在里面生成RealMenuSource对象
 *
 */
public class ProxyMenuSource implements MenuSource {
    private RealMenuSource realMenuSource;
    private String source;

    public ProxyMenuSource(String source){
        this.source=source;
    }

    /**
    * @description: 若RealMenuSource对象没有初始化资源文件则初始化资源文件
     *              否则直接加载资源文件显示
    * @Param:
    * @return:
    * @author: Cheng
    **/
    @Override
    public void show() {
        if(realMenuSource==null){
            realMenuSource=new RealMenuSource(source);
        }
        realMenuSource.show();
    }
}
