package com.ccbft.行为型.模板方法;

/**
 * 模板方法
 * <p>
 * 看过《如何说服女生上床》这部经典文章吗？女生从认识到上床的不变的步骤分为巧遇、打破僵局、展开追求、接吻、前戏、动手、爱抚、进去八大步骤(Template method)，
 * 但每个步骤针对不同的情况，都有不一样的做法，这就要看你随机应变啦(具体实现)；
 * 模板方法模式：模板方法模式准备一个抽象类，将部分逻辑以具体方法以及具体构造子的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。
 * 不同的子类可以以不同的方式实现这些抽象方法，从而对剩余的逻辑有不同的实现。先制定一个顶级逻辑框架，而将逻辑的细节留给具体的子类去实现。
 * <p>
 * <p>
 * <p>
 * 优点：
 * 提高代码复用性
 * 将相同部分的代码放在抽象的父类中，而将不同的代码放入不同的子类中。
 * 实现了反向控制
 * 通过一个父类调用其子类的操作，通过对子类的具体实现扩展不同的行为，实现了反向控制 ，并符合“开闭原则”。
 * 缺点：
 * 对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象。
 * 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度。
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