package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SpaceBase{

    private String name;
    private int posX;
    private int posY;
    private ArrayList<SpaceShip> shipList;



    public SpaceBase(String name, int posX, int posY) {
        setName(name);
        setPosX(posX);
        setPosY(posY);
        shipList = new ArrayList<>();
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
        if(spaceShip == null){
            throw new NullPointerException("Wurde nicht initialisiert");
        } else {
            if(shipList.contains(spaceShip)) {
                throw new IllegalArgumentException("Befindet sich bereits in der Liste");
            } else {
                return shipList.add(spaceShip);
            }
        }
    }

    public SpaceShip moveShipToSpaceBase(Long id, SpaceBase spaceBase) {
        if (id == 0 || spaceBase == null) {
            return null;
        } else {
            SpaceShip ship = null;
            for (int i = 0; i < shipList.size(); i++) {
                if (shipList.get(i).getId().equals(id)) {
                    ship = shipList.remove(i);
                    break;
                } else {
                    if (ship != null) {
                        ship.moveTo(spaceBase.getPosX(), spaceBase.getPosY());
                        spaceBase.docking(ship);
                        return ship;
                    }
                }
            }
            arrangeShips();
            return ship;
        }
    }

    public List<SpaceShip> arrangeShips() {
        ArrayList<SpaceShip> sortedShips = shipList;
        ArrayList sorterShips = new ArrayList(sortedShips);
        Collections.sort(sorterShips);
        return  sortedShips;
    }

    public void arrangeShipsByFuel(){
        shipList.sort(new FuelComparator());
    }



}
