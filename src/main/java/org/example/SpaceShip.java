package org.example;

import java.util.Comparator;
import java.util.Objects;

public class SpaceShip{
    private  final static  double  max_fuel = 2000;
    private final static double fuel_consumption = 3.58;
    private static Long idCounter = 100L;
    private  Long id;
    private int posX;
    private int posY;
    private double fuel;
    private SpaceBase homeBase;
    private SpaceBase dockingBase;


    public SpaceShip(int posX, int posY, double fuel, SpaceBase homeBase) {
        setPosX(posX);
        setPosY(posY);
        refuel(fuel);
        setHomeBase(homeBase);
        idCounter++;
        id = idCounter;
    }

    public SpaceShip() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(Long idCounter) {
        SpaceShip.idCounter = idCounter;
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

    public double getFuel() {
        return fuel;
    }

    public void refuel (double fuel) {
        double fuelAddierer = getFuel() + fuel;

        if(fuel <= 0){
            throw new IllegalArgumentException(fuel + " Darf keinen negativen Wert haben");
        } else {
            if (fuelAddierer > max_fuel) {
                this.fuel = max_fuel;
                System.out.println("fuel insgesamt " + fuel);
            } else {
                this.fuel = fuelAddierer;
            }
        }
    }

    public SpaceBase getHomeBase() {
        return homeBase;
    }

    public void setHomeBase(SpaceBase homeBase) {
        this.homeBase = homeBase;
    }

    public SpaceBase getDockingBase() {
        return dockingBase;
    }

    public void setDockingBase(SpaceBase dockingBase) {
        if(dockingBase == homeBase){
            refuel(max_fuel);
        } else {
            this.dockingBase = dockingBase;
        }
    }

    public void moveTo(int posX, int posY){
        double distance = calculateDistanceTo(posX,posY);

        if(calculateConsumption(distance) > max_fuel){
            throw new IllegalArgumentException(distance + "Die Distanz ist größer als die Tankreichweite");
        } else {
            fuel = getFuel() - calculateConsumption(distance);
            this.posX = posX;
            this.posY = posY;
        }
    }

    private double calculateDistanceTo(int posX, int posY) {
        return Math.sqrt(posX + posY);
    }

    private double calculateConsumption(double distanceInAU){
        if( distanceInAU <= 0){
            return 0;
        } else {
            return distanceInAU * fuel_consumption;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceShip spaceShip = (SpaceShip) o;
        return Objects.equals(id, spaceShip.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isHomeBase(SpaceBase spaceBase){
        return spaceBase == homeBase;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("SpaceShip{").append("id=").append(id).append(", posX=").append(posX).append(", posY=").append(posY).append(", fuel=").append(fuel).append(", homeBase=").append(homeBase).append('}').toString();
    }
}
