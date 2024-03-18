package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceBaseTest {

    @Test
    void setName() {
        SpaceBase base = new SpaceBase();
        base.setName("Starbase");
        assertEquals("Starbase",base.getName());
    }

    @Test
    void setNameBlank(){
        SpaceBase base = new SpaceBase();

        assertThrows(IllegalArgumentException.class, ()-> base.setName(""));
    }

    @Test
    void setPosX() {
        SpaceBase base = new SpaceBase();
        base.setPosX(10);
        assertEquals(10,base.getPosX());
    }

    @Test
    void setPosY() {
        SpaceBase base = new SpaceBase();
        base.setPosY(10);
        assertEquals(10,base.getPosY());
    }

    @Test
    void docking() {
        SpaceBase base = new SpaceBase("Starbase",10,10);
        SpaceShip ship = new SpaceShip(15,15,100, base);

        SpaceBase base2 = new SpaceBase("Base2",20,20);
        SpaceShip ship2 = new SpaceShip(30,30,200,base2);

        assertTrue(base.docking(ship2));
        assertTrue(base2.docking(ship));
        base.toString();
    }

    @Test
    void dockingNull() {
        SpaceBase base = new SpaceBase();
        SpaceShip ship = new SpaceShip();
        try {
            base.docking(ship);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    void dockingMultiple() {
        SpaceBase base = new SpaceBase("Starbase",10,10);
        SpaceShip ship = new SpaceShip(15,15,100, base);


        try {
            base.docking(ship);
            base.docking(ship);
        } catch (IllegalArgumentException ie) {
            assertTrue(ie instanceof IllegalArgumentException);
        }
    }

    @Test
    void moveShipToSpaceBase() {
        SpaceBase base = new SpaceBase("Starbase",10,10);
        SpaceShip ship = new SpaceShip(15,15,100, base);
        SpaceBase base2 = new SpaceBase("Base2",30,30);

        base.moveShipToSpaceBase(ship.getId(),base2);
        assertNotEquals(ship.getHomeBase(),base2);
        assertEquals(ship.getHomeBase(), base);
    }

    @Test
    void arrangeShips() {
        SpaceBase base = new SpaceBase("Starbase",10,10);
        SpaceShip ship = new SpaceShip(15,15,100, base);
        SpaceShip ship2 = new SpaceShip(20,20,150, base);
        SpaceShip ship3 = new SpaceShip(30,20,150, base);

        assertTrue(base.docking(ship));
        assertTrue(base.docking(ship2));
        assertTrue(base.docking(ship3));

        System.out.println(base.toString());

    }

    @Test
    void arrangeShipsByFuel() {
        SpaceBase base = new SpaceBase("Starbase",10,10);
        SpaceShip ship = new SpaceShip(15,15,100, base);
        SpaceShip ship2 = new SpaceShip(20,20,150, base);
        SpaceShip ship3 = new SpaceShip(30,20,150, base);

        assertTrue(base.docking(ship));
        assertTrue(base.docking(ship2));
        assertTrue(base.docking(ship3));

        base.arrangeShipsByFuel();

        base.toString();
    }

    @Test
    void testToString() {
        SpaceBase base = new SpaceBase("Starbase",10,10);
        SpaceBase base1 = new SpaceBase("Test 1",20,20);


        SpaceShip ship = new SpaceShip(15,15,100, base);
        SpaceShip ship2 = new SpaceShip(20,20,150, base1);
        SpaceShip ship3 = new SpaceShip(30,20,150, base);

        assertTrue(base1.docking(ship));
        assertTrue(base1.docking(ship2));
        assertTrue(base1.docking(ship3));

        System.out.println(base1.toString());

    }
}