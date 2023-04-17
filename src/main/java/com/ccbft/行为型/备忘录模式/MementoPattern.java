package com.ccbft.行为型.备忘录模式;

import java.util.ArrayList;
import java.util.List;

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 改变发起人对象的状态并将其存储在备忘录中
        originator.setState("State #1");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());

        // 从备忘录列表中获取最后一个状态并恢复给发起人对象
        originator.getStateFromMemento(caretaker.get(2));
        // 在恢复状态时，我们从最新保存的状态（即下标为 2 的备忘录对象）开始恢复，
        // 然后逐个返回早期保存的状态（即下标为 1 和 0 的备忘录对象）
        System.out.println("First recovered State: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second recovered State: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("Third recovered State: " + originator.getState());
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 发起人类
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

// 管理者类
class Caretaker {
    private List<Memento> mementoList = new ArrayList();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}