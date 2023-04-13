package com.ccbft.结构型.代理模式;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {
    public static void main(String[] args) {
        // 创建目标对象
        UserDao userDao = new UserDao();

        // 创建CGLIB代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new UserDaoProxy(userDao));

        // 获取代理对象
        UserDao proxyUserDao = (UserDao) enhancer.create();

        // 调用代理方法
        proxyUserDao.save();
    }
}



// 目标对象
class UserDao {
    public void save() {
        System.out.println("保存用户信息");
    }
}

// 代理对象
class UserDaoProxy implements MethodInterceptor {
    private Object target;

    public UserDaoProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
        Object returnValue = method.invoke(target, objects);
        System.out.println("提交事务");
        return returnValue;
    }
}