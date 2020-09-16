package com.traveler100.dp.strategy;

/**
 * 保安 类
 * @author 行百里者
 */
public class SecurityMan implements Comparable<SecurityMan> {

    //安保经验
    int experience;
    //颜值
    int beauty;

    public SecurityMan(int experience, int beauty) {
        this.experience = experience;
        this.beauty = beauty;
    }

    @Override
    public int compareTo(SecurityMan o) {
        if (this.experience > o.experience) {
            return -1;
        }
        if (this.experience < o.experience) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "SecurityMan{" +
                "experience=" + experience +
                ", beauty=" + beauty +
                '}';
    }
}
