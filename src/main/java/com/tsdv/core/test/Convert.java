package com.tsdv.core.test;

import com.tsdv.core.Device;
import com.tsdv.core.Location;

public class Convert {
    public static void main(String[] args) {
        Device device1 = new Device();
        Device device2 = new Device();
        device1.setLocation(new Location("A", 1, 2, 3));
        device2.setLocation(new Location("B", 4, 5, 6));

        device1.updataLocation(device2.getLocation(), 10);

        System.out.println("===>>>New Position: " + device1.getLocation());
    }
}
