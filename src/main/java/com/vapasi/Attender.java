package com.vapasi;

public class Attender implements Observer {
    private boolean isParkingLotFull;

    public Attender() {

    }

    @Override
    public void notify(boolean isParkingLotFull) {
        this.isParkingLotFull = isParkingLotFull;
    }
}
