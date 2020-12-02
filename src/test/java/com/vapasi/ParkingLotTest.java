package com.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    private ParkingLot parkingLot = ParkingLot.createInstance();

    @Test
    public void shouldReturnParkingSlotNumber() {
        Car myCar = new Car("KA01MP9087");
        int parkingSlotNo = parkingLot.parkVehicle(myCar);
        assertTrue(parkingSlotNo!=0);
    }

}
