import parkinglot.factory.VehicleFactory;
import parkinglot.model.Ticket;
import parkinglot.model.Vehicle;
import parkinglot.model.VehicleType;
import parkinglot.service.ParkingService;
import parkinglot.service.PaymentService;
import parkinglot.strategy.HourlyPricingStrategy;

void main() {
    try {
        ParkingService parkingService = new ParkingService(2);
        PaymentService paymentService = new PaymentService(new HourlyPricingStrategy());

        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "UP-01-1234");
        Ticket ticket1 = parkingService.parkVehicle(car);
        IO.println(ticket1);
        double amount1 = paymentService.processPayment(ticket1);
        IO.println("You paid " + amount1);

        Vehicle bike = VehicleFactory.createVehicle(VehicleType.BIKE, "UP-02-5678");
        Ticket ticket2 = parkingService.parkVehicle(bike);
        IO.println(ticket2);
        double amount2 = paymentService.processPayment(ticket2);
        IO.println("You paid " + amount2);
//        Vehicle car2 = VehicleFactory.createVehicle(VehicleType.CAR, "UP-08-9978");
//        parkingService.parkVehicle(car2);

    } catch (Exception e) {
        IO.println("Error: " + e.getMessage());
    }
}

