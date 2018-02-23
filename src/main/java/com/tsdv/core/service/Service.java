package com.tsdv.core.service;

import com.tsdv.core.component.Constant;
import com.tsdv.core.component.Device;
import com.tsdv.core.component.Location;
import com.tsdv.core.component.Utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Service {
    private static Scanner sc = new Scanner(System.in);
    private Location locA;
    private Location locB;
    private static double totalPath;

    public void getTravelInfo(Device device) {
        locA = chooseLocation();
        device.setLocation(locA);

        locB = chooseLocation();
        device.selectLocation(locB);

        System.out.println("Choose your speed: ");
        device.setSpeed(sc.nextDouble());

        System.out.println("Info your order: " + device.toString());

        totalPath = new Utilities().distanceBetween(locA, locB);
        System.out.println("===>>>Total length path: " + totalPath + "m");
        System.out.println("===>>>Time prediction: " + totalPath / (device.getSpeed()) + "s \n");
    }

    private void startTravel(Device device) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        double distanceTravelled = 0;

        while (true) {
            device.updataLocation(locB, distanceTravelled);

            distanceTravelled += (Calendar.getInstance().getTimeInMillis() - startTime) * Math.pow(10, -3) * device.getSpeed();
            if (distanceTravelled > totalPath) {
                distanceTravelled = totalPath;
            }
//            System.out.println("==>>distanceTravelled: " + distanceTravelled);

            if (distanceTravelled == totalPath) {
                device.updataLocation(locB, 0);
                break;
            } else {
                handleMenu(device);
            }
        }
    }

    private static Location chooseLocation() {
        System.out.println("Type location name, longitude, latitude, altitude: ");

        String locationName = sc.nextLine();
        double longitude = sc.nextDouble();
        double latitude = sc.nextDouble();
        double altitude = sc.nextDouble();

        sc.nextLine();

        return new Location(locationName, longitude, latitude, altitude);
    }

    public void checkHandleAndImplement(Device device) {
        String choose = sc.next();
        switch (choose.toUpperCase()) {
            case Constant.YES:
            case Constant.YES_PART:
                System.out.println("\nWish you have a good travel :)\n\n");
                createMenu();
                startTravel(device);

                endTravel();
                break;
            case Constant.NO:
            case Constant.NO_PART:
                endTravel();

                break;
            default:
                break;
        }
    }

    private void endTravel() {
        System.out.println("See you again");
    }

    private void handleMenu(Device device) {

        switch (sc.nextInt()) {
            case Constant.CURRENT_POSITION:

                Date currentTime = Calendar.getInstance().getTime();
                System.out.println("Your position now is: " + device.getLocation().toString());
                System.out.println("Your speed now: " + device.getSpeed());
                System.out.println("Check at: " + currentTime + "\n");

                break;
            case Constant.DISTANCE:

                System.out.println("It's about " + device.distanceLocationList(locA, locB).get(0) + " meters from initial position & "
                        + device.distanceLocationList(locA, locB).get(1) + " meters to destination\n");

                break;
            case Constant.SPEED:
                System.out.println("Choose your speed you want: ");
                device.setSpeed(sc.nextDouble());
                break;
            case Constant.TIME_REMAIN:

                System.out.println("Time remain to dest: " + new Utilities().distanceBetween(device.getLocation(), locB)/(device.getSpeed()));
                break;
            default:
                System.out.println("Your type invalid, please try again!");
                handleMenu(device);
        }

    }

    private void createMenu() {
        System.out.println(".............MENU..............");
        System.out.println("1.Current position;");
        System.out.println("2.Distance;");
        System.out.println("3.Change your speed;");
        System.out.println("4.Time remain to destination.");
        System.out.println("...............................\n");
    }
}
