package com.vapasi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    public static final ParkingLot PARKINGLOT_INSTANCE = new ParkingLot();
    public static final int PARKINGLOT_CAPACITY = 2;

    Map<Object, Object> parkingMap = new HashMap<>();

    private List<Observer> observers;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }


    private ParkingLot() {
        observers = new ArrayList<Observer>();
    }

    public Object parkTheCar(Object carObject) throws ParkingUnavailableException {
        if(!isFull()) {
            Object token = new Object();
            parkingMap.put(token,carObject);
            notifyObservers(isFull());
            return token;
        }
        throw new ParkingUnavailableException("Parking Lot is Full");

    }

    public boolean isFull() {
        return parkingMap.size() == PARKINGLOT_CAPACITY;
    }

    public void notifyObservers(boolean isFull) {
        for(Observer observer: observers) {
            observer.notify(isFull);
        }
    }

    public Object unParkTheCar(Object token) {
        Object carObject = parkingMap.get(token);
        if (isAllotted(token)) {
            parkingMap.remove(token);
            notifyObservers(isFull());
            return carObject;
        }
        throw new NoSuchTokenException("No car is parked with this token");
    }

    public boolean isAllotted(Object carObject) {
        return parkingMap.containsKey(carObject);
    }

    public void clearParkingLot() {
        parkingMap.clear();
    }


}
