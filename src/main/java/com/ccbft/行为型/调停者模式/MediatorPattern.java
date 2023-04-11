package com.ccbft.行为型.调停者模式;

import java.util.Arrays;
import java.util.List;

/**
 * 四个MM打麻将，相互之间谁应该给谁多少钱算不清楚了，幸亏当时我在旁边，
 * 按照各自的筹码数算钱，赚了钱的从我这里拿，赔了钱的也付给我，一切就OK啦，俺得到了四个MM的电话。
 */
public class MediatorPattern {
    public static void main(String[] args) {
        // 创建四个账户
        Account a = new Account("A", 100);
        Account b = new Account("B", -20);
        Account c = new Account("C", -30);
        Account d = new Account("D", -50);

        // 创建调停者对象并注册四个账户
        Mediator mediator = new MahjongMediator(Arrays.asList(a, b, c, d));
        a.setMediator(mediator);
        b.setMediator(mediator);
        c.setMediator(mediator);
        d.setMediator(mediator);

        // A向B转账20元
        a.transfer(b, 20);

        // A向C转账30元
        a.transfer(c, 30);

        // D向A转账50元
        d.transfer(a, 50);
    }
}

// 抽象调停者
interface Mediator {
    void settle(Account sender, Account receiver, int amount);
}

// 具体调停者
class MahjongMediator implements Mediator {
    private List<Account> accounts;

    public MahjongMediator(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void settle(Account sender, Account receiver, int amount) {
        // 计算赚钱的总数和欠钱的总数
        int totalProfit = 0;
        int totalDebt = 0;
        for (Account account : accounts) {
            if (account.getBalance() > 0) {
                totalProfit += account.getBalance();
            } else if (account.getBalance() < 0) {
                totalDebt -= account.getBalance();
            }
        }

        // 如果赚钱的总数等于欠钱的总数，则结算完毕
        if (totalProfit == totalDebt) {
            for (Account account : accounts) {
                if (account.getBalance() > 0) {
                    account.settle(-account.getBalance());
                } else if (account.getBalance() < 0) {
                    account.settle(account.getBalance());
                }
            }
        }

        // 否则按比例结算
        else {
            int totalAmount = Math.min(totalProfit, totalDebt);
            for (Account account : accounts) {
                if (account == sender) {
                    account.addBalance(-amount);
                } else if (account == receiver) {
                    account.addBalance(amount);
                }

                if (account.getBalance() > 0) {
                    int profit = account.getBalance() * totalAmount / totalProfit;
                    account.settle(-profit);
                } else if (account.getBalance() < 0) {
                    int debt = account.getBalance() * totalAmount / totalDebt;
                    account.settle(debt);
                }
            }
        }
    }
}

// 抽象同事类
interface Colleague {
    void setMediator(Mediator mediator);

    void addBalance(int amount);

    void settle(int amount);
}

// 具体同事类
class Account implements Colleague {
    private String name;
    private int balance;
    private Mediator mediator;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public void settle(int amount) {
        System.out.println(name + "结算了" + amount + "元");
    }

    public void transfer(Account receiver, int amount) {
        mediator.settle(this, receiver, amount);
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
}