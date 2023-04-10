package com.ccbft.行为型.策略模式.strategy;

/**
 * @author Administrator
 * @date 2022/9/16 14:59
 */
public class FemalePersonStrategy implements PersonStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("女人");
    }
}
