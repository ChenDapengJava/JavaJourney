package com.traveler100.dp.decorator;

/**
 * 足球运动员的装饰器
 * @author 行百里者
 */
public class FootballPlayerDecorator extends Player {
    private Player player;

    public FootballPlayerDecorator(Player player) {
        this.player = player;
    }

    @Override
    public void transferFee() {
        this.player.transferFee();
    }
}

/**
 * 会进球的足球运动员装饰
 */
class GoalFootballPlayerDecorator extends FootballPlayerDecorator {

    public GoalFootballPlayerDecorator(Player player) {
        super(player);
    }

    @Override
    public void transferFee() {
        super.transferFee();
        System.out.println("-------进球狂魔这一类球员的身价y万欧---------");
    }
}

/**
 * 长得帅的足球运动员装饰
 */
class HandsomeFootballPlayerDecorator extends FootballPlayerDecorator {

    public HandsomeFootballPlayerDecorator(Player player) {
        super(player);
    }

    @Override
    public void transferFee() {
        super.transferFee();
        System.out.println("-------长得帅的足球员的身价z万欧---------");
    }
}

/**
 * 足球运动员中的大帝
 */
class GodFootballPlayerDecorator extends FootballPlayerDecorator {

    public GodFootballPlayerDecorator(Player player) {
        super(player);
    }

    @Override
    public void transferFee() {
        super.transferFee();
        System.out.println("-------我的护球像亨利，传说中的大帝，价值 +∞！！！ ---------");
    }
}
