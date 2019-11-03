package edu.tongji.designpattern.DevideByPattern.BridgePattern;



/**
 *   @created by Cheng
 *   空调API实体类：表示挂式空调
 *            方法：changeTem(): 改变挂失=式空调温度的函数
 */
public class HangingAirConditioner implements AirConditionerAPI{

    /**
     * @description: 用于改变挂式空调温度
     * @Param: dounle temperature
     * @return:
     * @author: Cheng
     **/
    @Override
    public void changeTem(double temperature) {
        System.out.println("修改挂式空调温度为："+temperature);
    }
}
