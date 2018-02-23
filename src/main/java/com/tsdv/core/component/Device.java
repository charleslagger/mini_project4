package com.tsdv.core.component;

import java.util.LinkedList;
import java.util.List;

public class Device {
    private int id = 0;
    private Location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //add new attribute
    private static double speed;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        Device.speed = speed;
    }

    public void updataLocation(Location dest, double lengthRoad){
        double d = Math.sqrt(Math.pow(this.location.getLatitude() - dest.getLatitude(),2) +
                Math.pow(this.location.getAltitude() - dest.getAltitude(), 2) +
                Math.pow(this.location.getLongitude() - dest.getLongitude(), 2));

        this.location = new Location("Middle Position", (1 - lengthRoad/d)*this.location.getLongitude() + (lengthRoad/d)*dest.getLongitude(),
                (1 - lengthRoad/d)*this.location.getLatitude() + (lengthRoad/d)*dest.getLatitude(),
                (1 - lengthRoad/d)*this.location.getAltitude() + (lengthRoad/d)*dest.getAltitude());
    }

    //TODO
    public Location selectLocation(Location location){
        return location;
    }

    public List<Double> distanceLocationList(Location initPosition, Location dest){
        Utilities utilities = new Utilities();
        List<Double> distanceLocationList = new LinkedList<>();

        distanceLocationList.add(utilities.distanceBetween(this.location, initPosition));
        distanceLocationList.add(utilities.distanceBetween(this.location, dest));

        return distanceLocationList;
    }

    @Override
    public String toString() {
        return "Device{" +
                "location=" + location +
                ", speed=" + speed + "m/s" +
                '}';
    }
}
