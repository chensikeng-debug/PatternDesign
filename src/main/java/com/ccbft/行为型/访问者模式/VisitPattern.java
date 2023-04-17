package com.ccbft.行为型.访问者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor（抽象访问者）：声明了一组访问方法，用于访问不同类型的元素。
 * <p>
 * ConcreteVisitor（具体访问者）：实现了抽象访问者中声明的方法，完成对具体元素的访问。
 * <p>
 * Element（抽象元素）：声明一个接受操作，接受一个访问者对象为参数。
 * <p>
 * ConcreteElement（具体元素）：实现了抽象元素中声明的接受操作，并根据访问者不同的需求调用访问者对应的方法。
 * <p>
 * ObjectStructure（对象结构）：包含元素集合，提供让访问者访问所有元素的方法。
 */
public class VisitPattern {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new ConcreteElementA());
        objectStructure.attach(new ConcreteElementB());

        ConcreteVisitorA visitorA = new ConcreteVisitorA();
        ConcreteVisitorB visitorB = new ConcreteVisitorB();

        objectStructure.accept(visitorA);
        objectStructure.accept(visitorB);
    }
}

// 访问者接口
interface Visitor {
    void visit(ConcreteElementA elementA);

    void visit(ConcreteElementB elementB);
}

// 具体访问者A
class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者A访问-->" + elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者A访问-->" + elementB.operationB());
    }
}

// 具体访问者B
class ConcreteVisitorB implements Visitor {

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者B访问-->" + elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者B访问-->" + elementB.operationB());
    }
}

// 元素接口
interface Element {
    void accept(Visitor visitor);
}

// 具体元素A
class ConcreteElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作。";
    }
}


// 具体元素B
class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作。";
    }
}

// 对象结构类
class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void attach(Element element) {
        elements.add(element);
    }

    public void detach(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
