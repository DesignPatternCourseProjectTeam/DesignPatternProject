package edu.tongji.designpattern.DevideByPattern.ProxyPattern;


/**
 * @created by Cheng
 * 真正资源类：模仿真正的资源加载过程
 *       属性：资源source
 *       方法：初始化函数默认加载资源
 *             loadFromDisk()函数加载资源
 */
public class RealMenuSource implements MenuSource {
    private String source;

    /**
    * @description: 构造函数，初始时要加载资源文件
    * @Param: String source
    * @return:
    * @author: Cheng
    **/
    public RealMenuSource(String source){
        this.source=source;
        loadFromDisk(source);
    }

    /**
    * @description: 显示的过程函数
    * @Param:
    * @return:
    * @author: Cheng
    **/
    @Override
    public void show() {
        System.out.println("Show"+source);
    }

    /**
    * @description: 加载资源的过程函数
    * @Param:
    * @return:
    * @author: Cheng
    **/
    private void loadFromDisk(String source){
        System.out.println("Loading"+source);
    }
}
