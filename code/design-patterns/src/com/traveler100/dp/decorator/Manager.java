package com.traveler100.dp.decorator;

/**
 * @author 行百里者
 */
public class Manager {
    public static void main(String[] args) {
//        Player player = new FootballPlayer();
//        Player player = new GoalFootballPlayer();
//        player.transferFee();

//        Player player = new GodFootballPlayerDecorator(new GoalFootballPlayerDecorator(new HandsomeFootballPlayerDecorator(new FootballPlayer())));
//        player.transferFee();

        // 只看足球运动员
        Player player = new FootballPlayer();
        // 给足球运动员加个会进球的装饰
        player = new GoalFootballPlayerDecorator(player);
        // 再给加个长得帅的装饰
        player = new HandsomeFootballPlayerDecorator(player);
        // 再加个大帝的装饰
        player = new GodFootballPlayerDecorator(player);

        // 看加完装饰后的身价
        player.transferFee();
    }
}
