package com.ccbft.行为型.策略模式;

import com.ccbft.行为型.策略模式.factory.PersonStrategyFactory;
import com.ccbft.行为型.策略模式.strategy.PersonStrategy;

/**
 * 策略选择器是传入一个Enum类，然后根据传入Enum的不同，选择了不同的继承类。从而实现了if else。优雅的过渡。
 *
 * @author Administrator
 * @date 2022/9/16 15:51
 */
public class Main {
    public static void main(String[] args) {

        String sex = "male";
        // 1.创建选择器
        // 2.传入入参，从而在选择器中获取到入参对应的策略，然后执行策略
        PersonStrategy personStrategy = PersonStrategyFactory.getPersonStrategy(sex);
        personStrategy.executeStrategy();
        // 2.传入入参，从而在选择器中获取到入参对应的策略，然后执行策略
    }

}
