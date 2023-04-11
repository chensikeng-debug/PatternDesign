package com.ccbft.结构型.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 在这个示例中，Component是抽象构件接口，定义了所有构件共有的方法operation()。
 *
 * Leaf是叶子构件类，实现了Component接口，并实现了自己的具体操作。
 *
 * Composite是合成构件类，也实现了Component接口，内部维护了一个List集合用于存储其它子构件，同时实现了对子构件的添加、删除和遍历等操作方法。
 *
 * 在测试代码中，首先创建了三个叶子构件对象，然后创建一个合成构件对象，并将三个叶子构件添加到其中。最后调用合成构件的operation()方法，会依次调用所有子构件的operation()方法，完成整个树形结构的遍历操作。
 *
 * 在这个示例中，合成模式被用来描述了整套礼物与其中的各个部分之间的关系。Gift Set对象是合成构件，包含了三个叶子构件T-shirt、Skirt和Bag，并能够将整套礼物作为一个整体进行操作。
 */
public class ComponentPattern {
    public static void main(String[] args) {
        // 创建叶子构件
        Leaf leaf1 = new Leaf("T-shirt");
        Leaf leaf2 = new Leaf("Skirt");
        Leaf leaf3 = new Leaf("Bag");

        // 创建合成构件
        Composite composite = new Composite("Gift Set");

        // 将叶子构件添加到合成构件中
        composite.add(leaf1);
        composite.add(leaf2);
        composite.add(leaf3);

        // 调用合成构件的操作方法
        composite.operation();
    }
}

// 抽象构件
interface Component {
    void operation();
}

// 叶子构件
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " is operated.");
    }
}

// 合成构件
class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private String name;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Composite " + name + " is operated.");
        for (Component component : components) {
            component.operation();
        }
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }
}
