package com.vapasi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.vapasi.ParkingLot.PARKINGLOT_INSTANCE;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @BeforeEach
    public void setup(){
        PARKINGLOT_INSTANCE.registerObserver(new Owner());
        PARKINGLOT_INSTANCE.registerObserver(new Attender());
        PARKINGLOT_INSTANCE.clearParkingLot();
    }

    @Test
    public void shouldParkCar() throws ParkingUnavailableException {
        Object carObject = new Object();
        Object token = PARKINGLOT_INSTANCE.parkTheCar(carObject);
        boolean actualOutput = PARKINGLOT_INSTANCE.isAllotted(token);
        assertEquals(true, actualOutput);
    }


    @Test
    public void shouldUnParkCar() throws ParkingUnavailableException {
        Object carObject = new Object();
        Object token = PARKINGLOT_INSTANCE.parkTheCar(carObject);
        carObject = PARKINGLOT_INSTANCE.unParkTheCar(token);
        boolean actualOutput = PARKINGLOT_INSTANCE.isAllotted(token);
        assertEquals(false, actualOutput);

        assertThrows(NoSuchTokenException.class, () -> PARKINGLOT_INSTANCE.unParkTheCar(new Object()));
    }

    @Test
    public void shouldPassParkingFullMessageToOwner() throws ParkingUnavailableException {
        PARKINGLOT_INSTANCE.parkTheCar(new Object());
        PARKINGLOT_INSTANCE.parkTheCar(new Object());
        assertTrue(Owner.isFullSignOn);
    }

    @Test
    public void shouldPassParkingAvailableAgainMessageToOwner() throws ParkingUnavailableException {
        PARKINGLOT_INSTANCE.parkTheCar(new Object());

        Object token =PARKINGLOT_INSTANCE.parkTheCar(new Object());
        assertTrue(Owner.isFullSignOn);

        PARKINGLOT_INSTANCE.unParkTheCar(token);
        assertFalse(Owner.isFullSignOn);
    }

    @Test
    public void shouldThrowParkingUnAvailableException() throws ParkingUnavailableException {
        PARKINGLOT_INSTANCE.parkTheCar(new Object());
        PARKINGLOT_INSTANCE.parkTheCar(new Object());

        assertThrows(ParkingUnavailableException.class,()->PARKINGLOT_INSTANCE.parkTheCar(new Object()));
    }
}
