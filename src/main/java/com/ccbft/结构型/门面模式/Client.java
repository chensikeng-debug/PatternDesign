package com.ccbft.结构型.门面模式;

/**
 * Facade是门面，SubSystem是子系统
 * 为了方便展示，将所有类都写在一起
 * <p>
 * 应用场景：
 * 1、为一个复杂模块或子系统提供一个简介的供外界访问的接口
 * 2、希望提高子系统的独立性
 * 3、通过门面模式提供一个高层接口，隔离客户端与子系统的直接交互，预防代码污染
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doAll();
    }


    // 子系统
    static class SubSystemA {
        public void doA() {
            System.out.println("SubSystemA.doA");
        }
    }

    // 子系统
    static class SubSystemB {
        public void doB() {
            System.out.println("SubSystemB.doB");
        }
    }

    // 子系统
    static class SubSystemC {
        public void doC() {
            System.out.println("SubSystemB.doC");
        }
    }

    static class Facade {
        private SubSystemA a = new SubSystemA();
        private SubSystemB b = new SubSystemB();
        private SubSystemC c = new SubSystemC();

        public void doAll() {
            this.a.doA();
            this.b.doB();
            this.c.doC();
        }

        public void doA() {
            this.a.doA();
        }

        public void doB() {
            this.b.doB();
        }

        public void doC() {
            this.c.doC();
        }
    }
}
