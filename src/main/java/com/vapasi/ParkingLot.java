package com.vapasi;

import java.util.HashMap;

public class ParkingLot {

    private HashMap<Integer, Car> slots;
    private static int token;

    public static final ParkingLot parkingLot = new ParkingLot();

    private ParkingLot() {
        slots = new HashMap<>();
        token = 0;
    }

    public static ParkingLot createInstance() {
        return parkingLot;
    }

    public void parkVehicle(int token, Car car) {
        if(token <= 0)
            throw new TokenException("Please get token before parking the vehicle.");
        if(slots.containsKey(token))
            throw new TokenException("Token already in use. Please get new token to park the vehicle");
        slots.put(token, car);
    }


    public void unParkVehicle(Car car) {
       slots.remove(car);
    }

    public boolean isParked(Car myCar) {
        return slots.containsValue(myCar);
    }

    public int generateToken() {
        return ++token;
    }

}
