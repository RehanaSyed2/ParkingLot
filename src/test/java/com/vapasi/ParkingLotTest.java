package com.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private ParkingLot parkingLot = ParkingLot.createInstance();
    Car myCar = new Car("KA01MP9087");

    @Test
    public void shouldReturnTokenForParkingTheVehicle() {
        int actualToken = parkingLot.generateToken();
        int expectedToken = 1;
        assertEquals(expectedToken, actualToken);
    }


    @Test
    public void shouldParkTheVehicle() {
        parkingLot.parkVehicle(parkingLot.generateToken(), myCar);
        assertTrue(parkingLot.isParked(myCar));
    }

    @Test
    public void shouldThrowExceptionWhenTryingToParkWithoutToken() {
        assertThrows(TokenException.class, ()->{parkingLot.parkVehicle(0, myCar);});
    }

    @Test
    public void shouldThrowExceptionWhenTryingToParkWithUsedToken() {
        parkingLot.parkVehicle(1, myCar);
        assertThrows(TokenException.class, ()->{parkingLot.parkVehicle(1, myCar);});
    }

    @Test
    public void shouldUnparkTheVehicle() {
        parkingLot.unParkVehicle(myCar);
        assertFalse(parkingLot.isParked(myCar));
    }

}
