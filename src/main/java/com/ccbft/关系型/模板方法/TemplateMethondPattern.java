package com.ccbft.关系型.模板方法;

/**
 * 模板方法
 *
 * 优点：
 *
 *     提高代码复用性
 *
 *     将相同部分的代码放在抽象的父类中，而将不同的代码放入不同的子类中。
 *
 *     实现了反向控制
 *
 *     通过一个父类调用其子类的操作，通过对子类的具体实现扩展不同的行为，实现了反向控制 ，并符合“开闭原则”。
 *
 * 缺点：
 *
 *     对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象。
 *     父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度。
 *
 * 和策略模式相比，它可以多一个公共的前置或者后置等部分公共代码，如果遇到有公共重复的有限考虑使用模板方法模式instead of策略模式
 *
 * @author Administrator
 * @date 2022/9/18 10:09
 */
public class TemplateMethondPattern {
    public static void main(String[] args) {
        // 煮食物
        CookingFood cookingFood = new CookingFood();
        cookingFood.cook();
        // 煮面食
        CookingNoodles cookingNoodles = new CookingNoodles();
        cookingNoodles.cook();
    }
}

abstract class Cooking {
    protected abstract void step1();

    protected abstract void step2();

    // 这个就是模板方法
    public void cook() {
        // 如公共的前置步骤可以放在父类抽象类中实现
        System.out.println("perpare job");
        step1();
        step2();
        // 如公共的后置步骤可以放在父类抽象类中实现
        System.out.println("post job");
    }
}

class CookingFood extends Cooking {

    @Override
    protected void step1() {
        System.out.println("放鸡蛋和西红柿");
    }

    @Override
    protected void step2() {
        System.out.println("少放盐和味精");
    }
}

class CookingNoodles extends Cooking {

    @Override
    protected void step1() {
        System.out.println("放面");
    }

    @Override
    protected void step2() {
        System.out.println("放调料");
    }
}