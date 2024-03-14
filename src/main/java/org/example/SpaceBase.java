package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SpaceBase{

    private String name;
    private int posX;
    private int posY;
    private ArrayList<SpaceShip> shipList;

    public SpaceBase(String name, int posX, int posY) {
        setName(name);
        setPosX(posX);
        setPosY(posY);
    }

    public SpaceBase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(name + "Darf nicht leer sein");
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean docking(SpaceShip spaceShip) {
        if (spaceShip == null) {
            throw new NullPointerException("spaceShip ist nicht initialisiert");
        } else {
            if (shipList.contains(spaceShip)) {
                throw new IllegalArgumentException("spaceShip ist bereits in der Liste vorhanden");
            } else {
                spaceShip.setDockingBase(this);
                return shipList.add(spaceShip);
            }
        }
    }

    public SpaceShip moveShipToSpaceBase(int id, SpaceBase spaceBase) {
        if (id == 0 || spaceBase == null) {
            return null;
        }

        SpaceShip ship = null;
        for (int i = 0; i < shipList.size(); i++) {
            if (shipList.get(i).getId() == id) {
                ship = shipList.remove(i);
                break;
            }
        }

        if (ship != null) {
            ship.moveTo(spaceBase.getPosX(), spaceBase.getPosY());
            spaceBase.docking(ship);
        }

        arrangeShips();

        return ship;
    }

    public ArrayList<SpaceShip> arrangeShips() {
        List<SpaceShip> sortedShips = Collections.unmodifiableList(shipList);
        List sortierteShips = new ArrayList(sortedShips);
        Collections.sort(sortierteShips);
        return (ArrayList<SpaceShip>) sortedShips;
    }

    public void arrangeShipsByFuel(){
        shipList.sort(new FuelComparator());
    }

}
