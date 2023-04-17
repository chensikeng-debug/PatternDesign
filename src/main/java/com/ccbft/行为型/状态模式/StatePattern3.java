package com.ccbft.行为型.状态模式;

/**
 * 假设有一个电梯系统，其中电梯可能有多种状态，包括停止、上行、下行等。
 * 不同状态下，电梯需要执行不同的操作。状态模式可以很好地解决这个问题。
 */
public class StatePattern3 {
    public static void main(String[] args) {
        // 创建一个电梯，初始状态为停止状态
        Lift lift = new Lift();
        lift.setState(new StopState());
        lift.run(); // 电梯开始运行

        System.out.println();

        // 测试上行状态
        lift.setState(new UpState());
        lift.open(); // 电梯门在上行时不能开
        lift.close(); // 电梯门关闭中
        lift.run(); // 电梯正在上行
        lift.stop(); // 电梯已经停止

        System.out.println();

        // 测试下行状态
        lift.setState(new DownState());
        lift.open(); // 电梯门在下行时不能开
        lift.close(); // 电梯门关闭中
        lift.run(); // 电梯正在下行
        lift.stop(); // 电梯已经停止
    }
}

// 状态接口
interface LiftState {
    void open();

    void close();

    void run();

    void stop();
}

// 停止状态
class StopState implements LiftState {

    @Override
    public void open() {
        System.out.println("电梯门开了");
    }

    @Override
    public void close() {
        System.out.println("电梯已经关闭");
    }

    @Override
    public void run() {
        System.out.println("电梯开始运行");
    }

    @Override
    public void stop() {
        System.out.println("电梯已经停止");
    }
}

// 上行状态
class UpState implements LiftState {

    @Override
    public void open() {
        System.out.println("电梯门在上行时不能开");
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭中");
    }

    @Override
    public void run() {
        System.out.println("电梯正在上行");
    }

    @Override
    public void stop() {
        System.out.println("电梯已经停止");
    }
}

// 下行状态
class DownState implements LiftState {

    @Override
    public void open() {
        System.out.println("电梯门在下行时不能开");
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭中");
    }

    @Override
    public void run() {
        System.out.println("电梯正在下行");
    }

    @Override
    public void stop() {
        System.out.println("电梯已经停止");
    }
}

// 电梯类
class Lift {
    private LiftState state;

    public void setState(LiftState state) {
        this.state = state;
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void run() {
        state.run();
    }

    public void stop() {
        state.stop();
    }

}