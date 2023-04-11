package com.ccbft.行为型.命令模式.实战;

import java.util.Stack;

/**
 * 实战代码，
 * 将每个操作封装成一个命令对象，并将它们添加到历史记录列表中，来支持撤销和重做操作。
 * 在执行每个命令时，会自动保存当前状态，以便在需要撤销时恢复。
 * 我们还可以通过循环遍历历史记录列表，执行每个命令对象的undo()方法，实现撤销操作。
 */

public class UndoRedo {
    public static void main(String[] args) {
        // 创建接收者对象
        Receiver receiver = new Receiver();

        // 创建命令历史记录对象
        CommandHistory history = new CommandHistory();

        // 创建具体命令对象并指定接收者
        Command command1 = new ConcreteCommand(receiver);
        Command command2 = new ConcreteCommand(receiver);

        // 添加到历史记录列表中
        history.push(command1);
        history.push(command2);

        // 执行操作
        while (!history.isEmpty()) {
            Command command = history.pop();
            command.execute();
        }

        // 撤销操作
        while (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        }
    }
}

// 定义命令接口
interface Command {
    void execute();

    void undo();
}

// 实现具体命令类
class ConcreteCommand implements Command {
    private Receiver receiver;
    private String state;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        state = receiver.getState(); // 保存状态
        receiver.action();
    }

    public void undo() {
        receiver.setState(state); // 恢复状态
    }
}

// 命令历史记录类
class CommandHistory {
    private Stack<Command> stack = new Stack<>();

    public void push(Command command) {
        stack.push(command);
    }

    public Command pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class Receiver {
    private String state;

    public void action() {
        System.out.println("执行命令");
        state = "new state"; // 更新状态
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
