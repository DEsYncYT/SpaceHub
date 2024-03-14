package org.example;

import java.util.Comparator;

public class IdComparator implements Comparator<SpaceShip> {
    @Override
    public int compare(SpaceShip o1, SpaceShip o2) {
        return o1.getId().compareTo(o2.getId());
    }

}
