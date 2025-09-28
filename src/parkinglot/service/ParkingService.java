package parkinglot.service;

import module java.base;
import parkinglot.exception.ParkingFullException;
import parkinglot.model.ParkingSpot;
import parkinglot.model.Ticket;
import parkinglot.model.Vehicle;

public class ParkingService {
    private final List<ParkingSpot> parkingSpotList;
    int capacity;
    int occupied;

    public ParkingService(int capacity) {
        this.capacity = capacity;
        parkingSpotList = new ArrayList<>();

        for (int i = 0; i <= capacity; i++) {
            this.parkingSpotList.add(new ParkingSpot("S" + i));
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) throws ParkingFullException {
        if (this.occupied >= this.capacity) throw new ParkingFullException("No parking spots available");

        for (ParkingSpot spot : parkingSpotList) {
            if (spot.isAvailable()) {
                spot.park(vehicle);
                this.occupied++;
                return new Ticket(UUID.randomUUID().toString(), vehicle);
            }
        }

        throw new ParkingFullException("No parking spots available");
    }

    public void removeVehicle(String spotId) {
        for (ParkingSpot spot : parkingSpotList) {
            if (spot.getId().equals(spotId) && !spot.isAvailable()) {
                spot.removeVehicle();
                this.occupied--;
                IO.println("Vehicle removed from spot " + spotId);
            }
        }
    }
}
