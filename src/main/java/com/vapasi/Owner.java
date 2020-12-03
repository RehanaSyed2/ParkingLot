package com.vapasi;

public class Owner implements Observer {

    public static boolean isFullSignOn;

    @Override
    public void notify(boolean isParkingLotFull) {
        isFullSignOn = isParkingLotFull;
    }
}
