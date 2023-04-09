package com.ccbft.装饰器模式;

import java.math.BigDecimal;

// 饮料接口
interface Beverage {
    String getDescription();

    BigDecimal cost();
}

// 具体饮料类
class Coffee implements Beverage {
    public String getDescription() {
        return "Coffee";
    }

    public BigDecimal cost() {
        return new BigDecimal("1.99");
    }
}

class Tea implements Beverage {
    public String getDescription() {
        return "Tea";
    }

    public BigDecimal cost() {
        return new BigDecimal("1.50");
    }
}

// 装饰器接口
interface Decorator extends Beverage {
    String getDescription();
}

// 具体调料类
class Milk implements Decorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public BigDecimal cost() {
        return beverage.cost().add(new BigDecimal("0.10"));
    }
}

class Sugar implements Decorator {
    Beverage beverage;

    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    public BigDecimal cost() {
        return beverage.cost().add(new BigDecimal("0.05"));
    }
}

class Lemon implements Decorator {
    Beverage beverage;

    public Lemon(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Lemon";
    }

    public BigDecimal cost() {
        return beverage.cost().add(new BigDecimal("0.25"));
    }
}

/**
 * 可以对茶和咖啡做扩展，对它俩加牛奶，加糖，加柠檬[[动态]扩展原有的对象，又不改变原有的代码]
 */
public class DecoratorPatternExample {

    public void testDecoratorPattern() {
        Beverage coffee = new Coffee();
        coffee = new Milk(coffee);
        coffee = new Sugar(coffee);

        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        Beverage tea = new Tea();
        tea = new Lemon(tea);

        System.out.println(tea.getDescription() + " $" + tea.cost());
    }

    public static void main(String[] args) {
        DecoratorPatternExample example = new DecoratorPatternExample();
        example.testDecoratorPattern();
    }
}