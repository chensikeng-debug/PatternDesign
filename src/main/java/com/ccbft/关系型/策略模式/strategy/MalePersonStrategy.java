package com.ccbft.关系型.策略模式.strategy;

/**
 * @author Administrator
 * @date 2022/9/16 14:58
 */
public class MalePersonStrategy implements PersonStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("男人");
    }
}
