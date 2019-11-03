package edu.tongji.designpattern.DevideByPattern.ProxyPattern;


/**
 * @created by Cheng
 * 资源类：假设点菜机上面的图片文件等资源有一个远程存放库
 *         用代理模式来减少访问带来的消耗
 */
public interface MenuSource {
    //资源的显示函数
    void show();
}
