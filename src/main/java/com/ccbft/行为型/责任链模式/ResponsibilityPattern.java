package com.ccbft.行为型.责任链模式;

public class ResponsibilityPattern {
    public static void main(String[] args) {
        // 使用示例
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();

        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(handlerC);

        Request requestA = new Request("typeA");
        handlerA.handleRequest(requestA);

        Request requestB = new Request("typeB");
        handlerA.handleRequest(requestB);

        Request requestC = new Request("typeC");
        handlerA.handleRequest(requestC);
    }
}

// 定义接口
interface Handler {
    void setNextHandler(Handler handler);
    void handleRequest(Request request);
}

// 实现具体处理者
class ConcreteHandlerA implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(Request request) {
        if (request.getType().equals("typeA")) {
            // 处理请求的逻辑
            System.out.println("ConcreteHandlerA.handleRequest");
        } else {
            // 转发请求给下一个处理者
            nextHandler.handleRequest(request);
        }
    }
}

class ConcreteHandlerB implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(Request request) {
        if (request.getType().equals("typeB")) {
            // 处理请求的逻辑
            System.out.println("ConcreteHandlerB.handleRequest");
        } else {
            // 转发请求给下一个处理者
            nextHandler.handleRequest(request);
        }
    }
}

class ConcreteHandlerC implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(Request request) {
        if (request.getType().equals("typeC")) {
            // 处理请求的逻辑
            System.out.println("ConcreteHandlerC.handleRequest");
        } else {
            // 转发请求给下一个处理者
            nextHandler.handleRequest(request);
        }
    }
}

// 定义请求类
class Request {
    private String type;

    public Request(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
