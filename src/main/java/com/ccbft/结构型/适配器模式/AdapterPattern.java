package com.ccbft.结构型.适配器模式;

/**
 * 通过使用适配器模式，你可以将现有的类转化为符合所需接口的类，从而避免了对原始类进行修改并且可以使代码更加灵活和可扩展。
 * 此外，适配器还可以隐藏基础系统的复杂性，提供更简单易懂的界面给客户端使用。
 * 配器就是源和目标的桥梁
 *
 * 【新的接口】 消除由于接口不匹配所造成的类的兼容性问题
 * 【单个对象】
 *
 */
public class AdapterPattern {
    // 假设客户端就是聋哑人，要想知道新闻联播主持人说的内容，就需要手语老师翻译
    public static void main(String[] args) {
        Translator adapter = new Adapter(new Speaker());
        String translator = adapter.translator();
        System.out.println(translator);
    }
}

class Speaker {
    public String speak() {
        return "新华社消息...";
    }
}

interface Translator {
    public String translator();
}

class Adapter implements Translator {

    private final Speaker speaker;

    // 让适配器持有源对象
    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translator() {
        return speaker.speak();
    }
}
