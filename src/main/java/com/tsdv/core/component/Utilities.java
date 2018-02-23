package com.tsdv.core.component;

public class Utilities {
    private Location location;

    public Utilities() {
    }

    public Utilities(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double distanceBetween(Location loc1, Location loc2) {
        return Math.sqrt(Math.pow(loc1.getLongitude() - loc2.getLongitude(), 2) +
                Math.pow(loc1.getLatitude() - loc2.getLatitude(), 2) +
                Math.pow(loc1.getAltitude() - loc2.getAltitude(), 2));

    }

    public double distanceTo(Location location) {
        return distanceBetween(this.getLocation(), location);
    }
}
