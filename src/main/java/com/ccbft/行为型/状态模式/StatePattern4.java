package com.ccbft.行为型.状态模式;

public class StatePattern4 {
    public static void main(String[] args) {
        // 创建一个工作对象，初始状态为空闲状态
        Work work = new Work();
        // 测试空闲状态
        work.handle(); // 当前是空闲状态
        work.setState(new BusyState());
        work.handle(); // 当前是忙碌状态

        // 测试请假状态
        work.setState(new VacationState());
        work.handle(); // 当前是请假状态
    }
}

// 状态接口
interface WorkState {
    void handle(Work work);
}

// 空闲状态
class FreeState implements WorkState {

    @Override
    public void handle(Work work) {
        System.out.println("当前是空闲状态");
    }
}

// 忙碌状态
class BusyState implements WorkState {

    @Override
    public void handle(Work work) {
        System.out.println("当前是忙碌状态");
    }
}

// 请假状态
class VacationState implements WorkState {

    @Override
    public void handle(Work work) {
        System.out.println("当前是请假状态");
    }
}

// 工作类
class Work {
    private WorkState state;

    public Work() {
        this.state = new FreeState();
    }

    public void setState(WorkState state) {
        this.state = state;
    }

    public void handle() {
        state.handle(this);
    }
}
