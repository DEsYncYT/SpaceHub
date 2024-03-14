package org.example;

import java.util.Comparator;

public class FuelComparator implements Comparator<SpaceShip> {
    @Override
    public int compare(SpaceShip o1, SpaceShip o2) {
        return Double.compare(o1.getFuel(), o2.getFuel());
    }
}
