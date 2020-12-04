package com.vapasi;

public class Owner implements Observer {

    public static boolean isFullSignOn;

    @Override
    public void notify(boolean isParkingLotFull) {
        isFullSignOn = isParkingLotFull;
        if (isFullSignOn) System.out.println("The ParkingLot is full");
        System.out.println("The ParkingLot is available again");
    }
}
