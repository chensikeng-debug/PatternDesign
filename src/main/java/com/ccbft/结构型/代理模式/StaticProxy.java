package com.ccbft.结构型.代理模式;
//代理模式[控制对对象的访问]，通常是因为原始对象无法满足某些特定要求或安全限制。
public class StaticProxy {
    public static void main(String[] args) {
        BuyHouse buyHouseProxy = new BuyHouseProxy(new BuyHouseImpl());
        buyHouseProxy.buyHouse();
    }
}

// 创建服务类接口
interface BuyHouse {
    void buyHouse();
}

// 实现服务接口
class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("我要买房");
    }
}

// 创建代理类
class BuyHouseProxy implements BuyHouse {
    // 持有的原始对象
    private BuyHouse buyHouse;
    public BuyHouseProxy(final BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }
    @Override
    public void buyHouse() {
        System.out.println("买房前准备");
        buyHouse.buyHouse();
        System.out.println("买房后装修");
    }
}