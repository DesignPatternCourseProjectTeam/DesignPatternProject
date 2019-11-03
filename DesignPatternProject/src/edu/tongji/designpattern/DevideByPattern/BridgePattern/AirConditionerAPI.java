package edu.tongji.designpattern.DevideByPattern.BridgePattern;

/**
 *   @created by Cheng
 *   空调API接口：用于桥接模式
 *          方法：changeTem(): 改变温度的函数
 */
public interface AirConditionerAPI {

     /**
     * @description: 用于改变空调温度
     * @Param: dounle temperature
     * @return:
     * @author: Cheng
     **/
     void changeTem(double temperature);
}
