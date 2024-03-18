package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceShipTest {

    @Test
    void setId() {
        SpaceShip ship = new SpaceShip(10,10,100.00,new SpaceBase("Starbase",30,30));

        ship.setId(102L);
        assertEquals(102L,ship.getId());
        System.out.println(ship.getId());
    }

    @Test
    void refuelGueltigerWert() {
        SpaceShip ship = new SpaceShip(10,10,100.00,new SpaceBase("Starbase",30,30));

        ship.refuel(400);
        assertEquals(500,ship.getFuel());
        System.out.println(ship.toString());
    }

    @Test
    void refuelUngueltigerWert() {
        SpaceShip ship = new SpaceShip(10,10,100.00,new SpaceBase("Starbase",30,30));

        ship.refuel(2000);
        assertEquals(2000,ship.getFuel());
        System.out.println(ship.toString());
    }

    @Test
    void setHomeBase() {
        SpaceShip ship = new SpaceShip(10,10,100.00,new SpaceBase("Starbase",30,30));
        SpaceBase base = new SpaceBase("TestBase",404,405);
        ship.setHomeBase(base);

        assertEquals(base, ship.getHomeBase());
        System.out.println(base.toString());
        System.out.println(ship.toString());
    }


    @Test
    void moveTo() {
        SpaceShip ship = new SpaceShip(10,10,100.00,new SpaceBase("Starbase",30,30));

        ship.moveTo(40,40);
        assertEquals(40,ship.getPosX());
        assertEquals(40,ship.getPosY());
        System.out.println(ship.toString());

    }
}