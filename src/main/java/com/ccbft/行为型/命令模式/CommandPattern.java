package com.ccbft.行为型.命令模式;

public class CommandPattern {
    public static void main(String[] args) {
        // 创建接收者对象
        Receiver receiver = new Receiver();

        // 创建具体命令对象并指定接收者
        Command command = new ConcreteCommand(receiver);

        // 创建命令请求者，并设置具体命令对象
        Invoker invoker = new Invoker();
        invoker.setCommand(command);

        // 执行命令
        invoker.executeCommand();
    }
}

// 定义命令接口
interface Command {
    public void execute();
}

// 实现具体命令类
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();
    }
}

// 命令请求者
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// 接收者
class Receiver {
    public void action() {
        System.out.println("执行命令");
    }
}