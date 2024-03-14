package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceBaseTest {

    @Test
    void setName() {
        SpaceBase base = new SpaceBase();
        base.setName("Starbase");
    }

    @Test
    void setNameBlank(){
        SpaceBase base = new SpaceBase();
        base.setName("");
    }

    @Test
    void setPosX() {
        SpaceBase base = new SpaceBase();
        base.setPosX(10);
    }

    @Test
    void setPosY() {
        SpaceBase base = new SpaceBase();
        base.setPosY(10);
    }

    @Test
    void docking() {
        SpaceBase base = new SpaceBase("Starbase",10,10);
        SpaceShip ship = new SpaceShip(10,10,100,base);

        ship.setDockingBase(base);
    }

    @Test
    void dockingNull() {
        SpaceBase base = new SpaceBase();
        SpaceShip ship = new SpaceShip();

        base.docking(ship);
    }

    @Test
    void moveShipToSpaceBase() {
    }

    @Test
    void arrangeShips() {
    }

    @Test
    void arrangeShipsByFuel() {

    }
}