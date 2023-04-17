package com.ccbft.行为型.访问者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个图书馆管理系统中，图书馆藏书是对象结构，而对于这些藏书的各种操作（如借出、归还、续借、查询等）则是不断更新和变化的算法。
 * 使用访问者模式可以将这些算法抽象为访问者，将图书馆藏书抽象为元素，从而实现算法和对象结构的分离。
 */
public class VisitPattern2 {
    public static void main(String[] args) {
        // 初始化图书馆
        Library library = new Library();
        library.addItem(new Book("Java编程思想"));
        library.addItem(new Book("设计模式"));
        library.addItem(new Book("算法导论"));

        // 借出和归还图书
        BorrowVisitor borrowVisitor = new BorrowVisitor();
        ReturnVisitor returnVisitor = new ReturnVisitor();
        library.accept(borrowVisitor);
        System.out.println("--------------------");
        library.accept(returnVisitor);
    }
}

// 访问者接口
interface Vistor {
    void visit(Book book);
}

class BorrowVisitor implements Vistor {
    public void visit(Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            System.out.println("借出《" + book.getTitle() + "》成功！");
        } else {
            System.out.println("《" + book.getTitle() + "》已经被借走了！");
        }
    }
}

// 具体访问者B：还书
class ReturnVisitor implements Vistor {
    public void visit(Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            System.out.println("归还《" + book.getTitle() + "》成功！");
        } else {
            System.out.println("《" + book.getTitle() + "》并未被借走！");
        }
    }
}

// 元素接口
interface Elem {
    void accept(Vistor visitor);
}

// 具体元素：图书
class Book implements Elem {
    private String title;
    private boolean isBorrowed;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void accept(Vistor visitor) {
        visitor.visit(this);
    }
}

// 对象结构类
class Library {
    private List<Elem> items = new ArrayList<>();

    public void addItem(Elem item) {
        items.add(item);
    }

    public void removeItem(Elem item) {
        items.remove(item);
    }

    public void accept(Vistor visitor) {
        for (Elem item : items) {
            item.accept(visitor);
        }
    }
}