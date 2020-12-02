package com.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    private ParkingLot parkingLot = ParkingLot.createInstance();

    @Test
    public void shouldParkTheVehicle() {
        Car myCar = new Car("KA01MP9087");
        parkingLot.parkVehicle(myCar);
        assertTrue(parkingLot.isParked(myCar));
    }

    @Test
    public void shouldUnparkTheVehicle() {
        Car myCar = new Car("KA01MP9087");
        parkingLot.unParkVehicle(myCar);
        assertFalse(parkingLot.isParked(myCar));
    }

}
