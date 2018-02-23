package com.tsdv.core.test;

import com.tsdv.core.Constant;
import com.tsdv.core.Device;
import com.tsdv.core.Location;
import com.tsdv.core.Utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//TODO: hien thi thoi gian tu hien tai toi dich
public class AppTest {
    private static Scanner sc = new Scanner(System.in);
    private static double totalPathLengthRemain;
    private static Location locB;//dest
    private static double countDistance; //Tu A

    public static void main(String[] args) {
        Device device = new Device();

        getTravelInfo(device);

        System.out.println("Start your travel now? (y/n)");
        String choose = sc.next();
        switch (choose.toUpperCase()) {
            case Constant.YES:
            case Constant.YES_PART:
                System.out.println("\n\nWish you have a good travel :)");
                createMenu();
                startTravel(device);

                break;
            case Constant.NO:
            case Constant.NO_PART:
                endTravel();

                break;
            default:
                break;
        }
    }

    private static void endTravel() {
        System.out.println("See you again");
    }

    private static void startTravel(Device device) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        countDistance = 0;
        while (true) {
            device.updataLocation(locB, countDistance);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countDistance += (Calendar.getInstance().getTimeInMillis() - startTime) * device.getSpeed();
            totalPathLengthRemain = new Utilities().distanceBetween(device.getLocation(), locB);
            if(0 == totalPathLengthRemain){
                
                device.updataLocation(locB, totalPathLengthRemain);
                break;
            }

            handleEventChoose(device);
        }

        System.out.println("Your position now is: " + device.getLocation().toString());
        System.out.println("Your speed:" + device.getSpeed());
        System.out.println("Check at: " + Calendar.getInstance().getTime());
        System.out.println("Road length remain: " + new Utilities(device.getLocation()).distanceTo(locB)+ "\n\n");
        System.out.println("==>>Finish! Your position now is destination");
    }

    private static void handleEventChoose(Device device) {

        switch (sc.nextInt()) {
            case Constant.CURRENT_POSITION:

                Date currentTime = Calendar.getInstance().getTime();
                System.out.println("Your position now is: " + device.getLocation().toString());
                System.out.println("Your speed:" + device.getSpeed());
                System.out.println("Check at: " + currentTime);
                System.out.println("Road length: " + new Utilities(device.getLocation()).distanceTo(locB)+ "\n\n");
                break;
            case Constant.NEXT_LOCATION:
                break;
            case Constant.DISTANCE:
                break;
            case Constant.SPEED:
                System.out.println("Choose your speed you want: ");
                device.setSpeed(sc.nextDouble());
                break;
            default:
                System.out.println("Your type invalid, please try again!");
                handleEventChoose(device);
        }

    }

    private static void createMenu() {
        System.out.println(".............MENU..............");
        System.out.println("1.Current position");
        System.out.println("2.Choose next location");
        System.out.println("3.Distance");
        System.out.println("4.Change your speed");
        System.out.println("...............................\n");
    }

    private static void getTravelInfo(Device device) {
        Location locA = chooseLocation();
        device.setLocation(locA);

        locB = chooseLocation();
        device.selectLocation(locB);

        System.out.println("Choose your speed: ");
        device.setSpeed(sc.nextDouble());

        System.out.println("Info your order: " + device.toString());

        totalPathLengthRemain = new Utilities().distanceBetween(locA, locB);
        System.out.println("===>>>Total length path: " + totalPathLengthRemain);
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
}
