package com.traveler100.dp.decorator;

/**
 * @author 行百里者
 */
public class Player {
    public void transferFee() {
        System.out.println("-------综合计算运动员的平均身价-----");
    }
}

class FootballPlayer extends Player {
    @Override
    public void transferFee() {
        System.out.println("------足球运动员的平均身价x万欧-----");
    }
}

class GoalFootballPlayer extends FootballPlayer {
    @Override
    public void transferFee() {
        super.transferFee();
        System.out.println("------进球狂魔，这一类球员的身价----------");
    }
}
