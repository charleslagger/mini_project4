package com.tsdv.core.controller;

import com.tsdv.core.component.Device;
import com.tsdv.core.service.Service;

public class Controller{
    private static Service service;

    public static void main(String[] args) {
        Device device = new Device();
        service = new Service();

        service.getTravelInfo(device);
        System.out.println("Start your travel now? (y/n)");
        service.checkHandleAndImplement(device);
    }
}
