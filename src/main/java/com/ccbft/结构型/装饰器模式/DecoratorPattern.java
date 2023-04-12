package com.ccbft.结构型.装饰器模式;

/**
 * 装饰第一代机器人
 * <p>
 * 功能增强
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        RobotDecorator robotDecorator = new RobotDecorator(new FirstRobot());
        robotDecorator.doSomething();
    }
}

interface Robot {
    void doSomething();
}

class FirstRobot implements Robot {

    @Override
    public void doSomething() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}

class RobotDecorator implements Robot {
    private Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
        System.out.println("跳舞、拖地");
    }
}
