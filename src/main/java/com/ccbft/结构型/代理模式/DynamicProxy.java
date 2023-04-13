package com.ccbft.结构型.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        proxyBuyHouse.buyHosue();
    }
}

interface BuyHouse {
    void buyHosue();
}

class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHosue() {
        System.out.println("我要买房");
    }
}

/**
 * 动态代理类，可以实现人力类型的代理
 */
class DynamicProxyHandler implements InvocationHandler {

    //  object可以是任意类型，且不需要和目标对象实现同一接口，什么类我都能代理。
    private Object object;

    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前准备");
        Object result = method.invoke(object, args);
        System.out.println("买房后装修");
        return result;
    }
}