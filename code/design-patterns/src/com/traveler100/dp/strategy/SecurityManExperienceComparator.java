package com.traveler100.dp.strategy;

import java.util.Comparator;

/**
 * @author 行百里者
 */
public class SecurityManExperienceComparator implements Comparator<SecurityMan> {

    @Override
    public int compare(SecurityMan o1, SecurityMan o2) {
        if (o1.experience < o2.experience) return -1;
        else if (o1.experience > o2.experience) return 1;
        return 0;
    }
}
