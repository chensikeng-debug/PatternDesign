package com.ccbft.行为型.命令模式;

/*下面是一些命令模式的应用案例：

    撤销和重做：命令模式可以用来支持撤销和重做操作。将每个操作封装成一个命令对象，并将其添加到命令历史记录列表中，当需要执行撤销或重做操作时，只需要从历史记录中取出相应的命令对象并执行即可。

    菜单和工具栏：在图形用户界面中，菜单和工具栏通常使用命令模式来处理用户的操作。将每个菜单项或工具栏按钮封装成一个命令对象，并将其与相应的操作绑定，当用户点击菜单项或工具栏按钮时，只需要执行相应的命令对象即可。

    宏命令：宏命令是由多个子命令组成的命令。将每个子命令封装成一个命令对象，并将它们组合成一个宏命令对象，当需要执行一系列操作时，只需要执行宏命令对象即可。

    日志和回放：命令模式可以用来记录系统的操作日志，并支持回放操作。将每个操作封装成一个命令对象，并将其添加到日志列表中，当需要执行回放操作时，只需要从日志列表中取出相应的命令对象并执行即可。

    队列和线程池：命令模式可以用来管理任务队列和线程池，将每个任务封装成一个命令对象，并将其添加到任务队列中，当需要执行任务时，只需要从队列中取出相应的命令对象并执行即可。同时，可以使用线程池来控制命令对象的执行，以提高系统的性能和效率。

    总之，命令模式在实战中有广泛的应用，它可以帮助我们更好地管理、优化和扩展系统的行为。
*/
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

        // 撤销命令
        invoker.undoCommand();
    }
}

// 定义命令接口
interface Command {
    public void execute();
    public void undo();
}

// 实现具体命令类
class ConcreteCommand implements Command {
    private Receiver receiver;
    private String state; // 用于保存命令执行前的状态

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

// 命令请求者
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public void undoCommand() {
        command.undo();
    }
}

// 接收者
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


