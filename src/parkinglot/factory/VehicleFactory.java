package parkinglot.factory;

import parkinglot.model.Bike;
import parkinglot.model.Car;
import parkinglot.model.Vehicle;
import parkinglot.model.VehicleType;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType type, String licensePlate) {
        return switch (type) {
            case VehicleType.CAR -> new Car(licensePlate, VehicleType.CAR);
            case VehicleType.BIKE -> new Bike(licensePlate, VehicleType.BIKE);
            default -> throw new IllegalArgumentException("Invalid vehicle type" + type);
        };
    }
}
