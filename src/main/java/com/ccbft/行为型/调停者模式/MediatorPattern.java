package com.ccbft.行为型.调停者模式;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现了一个简单的麻将游戏，四个玩家之间的结算问题通过调停者模式得到解决。当玩家之间输赢不清楚时，
 * 他们通过调停者向调停者报告自己赢得或输掉的筹码数，由调停者来计算每个玩家最终应该赢得或输掉的筹码数，并进行结算。
 * 这样，每个玩家就不需要互相之间进行计算，而是将结算问题交给了调停者处理，从而简化了程序的逻辑，提高了程序的可维护性和扩展性。
 */
// 定义玩家类
class Player {
    private String name;
    private int chips;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
    }

    public String getName() {
        return name;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    // 玩家从调停者处收到赢得的筹码
    public void receiveChips(int amount) {
        this.chips += amount;
    }

    // 玩家向调停者处支付输掉的筹码
    public void payChips(int amount) {
        this.chips -= amount;
    }
}

// 定义调停者类
class Mediator {
    private Map<Player, Integer> winMap = new HashMap<>();
    private Map<Player, Integer> loseMap = new HashMap<>();

    // 添加胜利的玩家和筹码数
    public void addWin(Player player, int amount) {
        winMap.put(player, amount);
    }

    // 添加失败的玩家和筹码数
    public void addLose(Player player, int amount) {
        loseMap.put(player, amount);
    }

    // 结算筹码
    public void settle() {
        for (Player winner : winMap.keySet()) {
            int amount = winMap.get(winner);
            for (Player loser : loseMap.keySet()) {
                if (!winner.equals(loser)) {
                    amount -= loseMap.get(loser);
                }
            }
            winner.receiveChips(amount);
        }
        winMap.clear();
        loseMap.clear();
    }
}

// 定义麻将游戏类
class MahjongGame {
    private Mediator mediator;
    private List<Player> players;

    public MahjongGame() {
        this.mediator = new Mediator();
        this.players = new ArrayList<>();
    }

    // 添加玩家
    public void addPlayer(Player player) {
        players.add(player);
    }

    // 玩家之间进行交互
    public void play() {
        // ... 进行麻将游戏 ...

        // 结算筹码
        for (Player winner : players) {
            int totalWin = 0;
            for (Player loser : players) {
                if (!winner.equals(loser)) {
                    // 计算赢得的筹码数
                    int chips = calculateChips(winner, loser);
                    totalWin += chips;
                    mediator.addLose(loser, chips);
                }
            }
            mediator.addWin(winner, totalWin);
        }
        mediator.settle();
    }

    // 计算玩家之间输赢的筹码数
    private int calculateChips(Player winner, Player loser) {
        // ... 根据规则计算筹码数 ...
        return 10;
    }
}

// 使用示例
public class MediatorPattern {
    public static void main(String[] args) {
        // 创建四个玩家，每个玩家初始有100个筹码
        Player a = new Player("A", 100);
        Player b = new Player("B", 100);
        Player c = new Player("C", 100);
        Player d = new Player("D", 100);

        // 创建麻将游戏并添加玩家
        MahjongGame game = new MahjongGame();
        game.addPlayer(a);
        game.addPlayer(b);
        game.addPlayer(c);
        game.addPlayer(d);

        // 进行游戏
        game.play();

        // 打印每个玩家的筹码数
        System.out.println("玩家A的筹码数：" + a.getChips());
        System.out.println("玩家B的筹码数：" + b.getChips());
        System.out.println("玩家C的筹码数：" + c.getChips());
        System.out.println("玩家D的筹码数：" + d.getChips());
    }
}