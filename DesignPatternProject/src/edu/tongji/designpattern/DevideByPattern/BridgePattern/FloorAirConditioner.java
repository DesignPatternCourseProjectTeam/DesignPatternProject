package edu.tongji.designpattern.DevideByPattern.BridgePattern;



/**
 *   @created by Cheng
 *   空调API实体类：表示立式空调
 *            方法：changeTem(): 改变立式空调温度的函数
 */
public class FloorAirConditioner implements AirConditionerAPI {

    /**
     * @description: 用于改变立式空调温度
     * @Param: dounle temperature
     * @return:
     * @author: Cheng
     **/
    @Override
    public void changeTem(double temperature) {
        System.out.println("修改立式空调温度为："+temperature);
    }
}
