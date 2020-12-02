package com.vapasi;

import java.util.HashMap;
import java.util.LinkedList;

public class ParkingLot {

    private HashMap<Integer, Car> slots;
    private static int slotNo;
    private LinkedList<Integer> availableSlots;

    public static final ParkingLot parkingLot = new ParkingLot();

    private ParkingLot() {
        slots = new HashMap<>();
        availableSlots = new LinkedList<>();
        slotNo = 0;
    }

    public static ParkingLot createInstance() {
        return parkingLot;
    }

    public int parkVehicle(Car car) {
        if(availableSlots.isEmpty())
        {
            slotNo++;
            slots.put(slotNo, car);
        } else {
            slots.put(availableSlots.getFirst(), car);
        }
        return slotNo;
    }


    public void unParkVehicle(int slotNo, Car car) {
        if(slots.containsKey(slotNo))
        {
            slots.remove(slotNo);
            availableSlots.add(slotNo);
        }
        else {
            //car is not parked
        }
    }
}
