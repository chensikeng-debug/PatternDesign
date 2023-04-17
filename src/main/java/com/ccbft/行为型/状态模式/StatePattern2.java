package com.ccbft.行为型.状态模式;

/**
 * 假设有一个订单系统，其中订单可能有多种状态，包括已创建、待付款、已完成等。
 * 不同状态下，订单需要执行不同的操作。状态模式可以很好地解决这个问题。
 */
public class StatePattern2 {
    public static void main(String[] args) {
        // 创建一个订单，初始状态为已创建
        Order order = new Order(new CreatedState());
        order.create(); // 订单已经创建
        order.pay(); // 付款成功
        System.out.println("");
        // 将状态改为待付款
        order.setState(new ToPayState());
        order.create(); // 订单已经创建
        order.pay(); // 付款成功
        order.complete(); // 订单完成
        System.out.println("");
        // 将状态改为已完成
        order.setState(new CompletedState());
        order.create(); // 订单已经创建
        order.pay(); // 订单已经付款，不能重复付款
        order.complete(); // 订单已经完成，不能重复完成
    }
}

// 状态接口
interface OrderState {
    void create();

    void pay();

    void complete();
}

// 订单已创建状态
class CreatedState implements OrderState {

    @Override
    public void create() {
        System.out.println("订单已经创建");
    }

    @Override
    public void pay() {
        System.out.println("付款成功");
    }

    @Override
    public void complete() {
        System.out.println("订单未付款，不能完成");
    }
}

// 订单待付款状态
class ToPayState implements OrderState {

    @Override
    public void create() {
        System.out.println("订单已经创建");
    }

    @Override
    public void pay() {
        System.out.println("付款成功");
    }

    @Override
    public void complete() {
        System.out.println("订单完成");
    }
}

// 订单已完成状态
class CompletedState implements OrderState {

    @Override
    public void create() {
        System.out.println("订单已经创建");
    }

    @Override
    public void pay() {
        System.out.println("订单已经付款，不能重复付款");
    }

    @Override
    public void complete() {
        System.out.println("订单已经完成，不能重复完成");
    }
}

// 订单类
class Order {
    private OrderState state;

    public Order(OrderState state) {
        this.state = state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void create() {
        state.create();
    }

    public void pay() {
        state.pay();
    }

    public void complete() {
        state.complete();
    }
}
