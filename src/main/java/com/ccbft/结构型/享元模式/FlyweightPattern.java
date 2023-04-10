package com.ccbft.结构型.享元模式;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 *
 * 定义：通过共享的方式高效的支持大量细粒度的对象。
 *
 * 主要解决：在有大量对象时，有可能会造成内存溢出，我们把其中共同的部分抽象出来，如果有相同的业务请求，直接返回在内存中已有的对象，避免重新创建。
 *
 * 何时使用：
 * 1、系统中有大量对象。
 * 2、这些对象消耗大量内存。
 * 3、这些对象的状态大部分可以外部化。
 * 4、这些对象可以按照内蕴状态分为很多组，当把外蕴对象从对象中剔除出来时，每一组对象都可以用一个对象来代替。
 * 5、系统不依赖于这些对象身份，这些对象是不可分辨的。
 * 如何解决：用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象。
 * 关键代码：用 HashMap 存储这些对象。
 * 应用实例： 1、JAVA 中的 String，如果有则返回，如果没有则创建一个字符串保存在字符串缓存池里面。
 * 优点：大大减少对象的创建，降低系统的内存，使效率提高。
 * 缺点：提高了系统的复杂度，需要分离出外部状态和内部状态，而且外部状态具有固有化的性质，不应该随着内部状态的变化而变化，否则会造成系统的混乱。
 * 简单来说，我们抽取出一个对象的外部状态（不能共享）和内部状态（可以共享）。然后根据外部状态的决定是否创建内部状态对象。
 * 内部状态对象是通过哈希表保存的，当外部状态相同的时候，不再重复的创建内部状态对象，从而减少要创建对象的数量
 */
public class FlyweightPattern {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        IFlyweight flyweight1 = flyweightFactory.getFlyweight("A");
        IFlyweight flyweight2 = flyweightFactory.getFlyweight("B");
        IFlyweight flyweight3 = flyweightFactory.getFlyweight("A");
        flyweight1.print();
        flyweight2.print();
        flyweight3.print();
        System.out.println(flyweightFactory.getFlyweightMapSize());
    }
}

// 1.创建享元对象接口
interface IFlyweight {
    void print();
}

// 2.创建具体享元对象
class Flyweight implements IFlyweight {
    private String id;

    public Flyweight(String id) {
        this.id = id;
    }

    @Override
    public void print() {
        System.out.println("Flyweight.id = " + getId() + " ...");
    }

    public String getId() {
        return id;
    }
}

class FlyweightFactory {
    private Map<String, IFlyweight> flyweightMap = new HashMap();

    public IFlyweight getFlyweight(String str) {
        IFlyweight flyweight = flyweightMap.get(str);
        if (flyweight == null) {
            flyweight = new Flyweight(str);
            flyweightMap.put(str, flyweight);
        }
        return flyweight;
    }

    public int getFlyweightMapSize() {
        return flyweightMap.size();
    }
}
