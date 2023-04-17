package com.ccbft.行为型.状态模式;

/**
 * State 接口定义了 handle() 方法，表示不同状态下的处理逻辑。
 * Context 类是含有状态的上下文类，包含 state和一些操作这个状态的方法
 */
public class StatePattern {
    public static void main(String[] args) {
        //初始化一个含有状态1的上下文对象
        Context context = new Context(new ConcreteState1());

        //请求处理
        context.request(); //输出：处理状态1的逻辑

        //改变状态为2并再次请求处理
        context.setState(new ConcreteState2());
        context.request(); //输出：处理状态2的逻辑
    }
}

//定义一个状态接口
interface State {
    void handle();
}

//实现两个具体的状态类
class ConcreteState1 implements State {
    public void handle() {
        System.out.println("处理状态1的逻辑");
    }
}

class ConcreteState2 implements State {
    public void handle() {
        System.out.println("处理状态2的逻辑");
    }
}

//定义一个含有状态的上下文类
class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(); //根据当前状态执行不同的行为
    }
}