package elevatorsystem.controller;

import elevatorsystem.model.Direction;
import elevatorsystem.model.FloorRequest;
import elevatorsystem.service.IElevatorService;

public class ElevatorController {
    private IElevatorService elevatorService;

    public ElevatorController(IElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }

    public void pressButton(int floor, Direction direction) {
        elevatorService.requestFloor(new FloorRequest(floor, direction));
    }

    public void stepElevators() {
        elevatorService.step();
    }
}
