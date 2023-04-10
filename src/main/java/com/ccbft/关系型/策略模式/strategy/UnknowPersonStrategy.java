package com.ccbft.关系型.策略模式.strategy;

/**
 * @author Administrator
 * @date 2022/9/16 15:00
 */
public class UnknowPersonStrategy implements PersonStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("未知的类型");
        throw new IllegalArgumentException("未知的类型错误");
    }
}
