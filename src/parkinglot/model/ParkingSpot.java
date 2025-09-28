package parkinglot.model;

public class ParkingSpot {
    private String id;
    private boolean available;
    private Vehicle vehicle;

    public ParkingSpot(String id) {
        this.id = id;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.available = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.available = true;
    }

    public String getId() {
        return id;
    }
}
