package com.ccbft.行为型.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();
        NewsSubscriber subscriber1 = new NewsSubscriber("张三");
        NewsSubscriber subscriber2 = new NewsSubscriber("李四");
        NewsSubscriber subscriber3 = new NewsSubscriber("王五");

        publisher.registerObserver(subscriber1);
        publisher.registerObserver(subscriber2);
        publisher.registerObserver(subscriber3);

        publisher.setNews("中国将举办2022冬奥会。");

        publisher.removeObserver(subscriber2);

        publisher.setNews("美国宣布对中国实施新的贸易限制。");
    }
}

// 主题接口
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// 具体主题类，即新闻发布者
class NewsPublisher implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

// 观察者接口，即订阅者
interface Observer {
    void update(String news);
}

// 具体观察者类，即新闻订阅者
class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " 收到新闻：" + news);
    }
}