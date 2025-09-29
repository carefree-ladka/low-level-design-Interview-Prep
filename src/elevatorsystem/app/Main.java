package elevatorsystem.app;

import elevatorsystem.controller.ElevatorController;
import elevatorsystem.model.Direction;
import elevatorsystem.service.impl.ElevatorService;

public class Main {
    void main() {
        ElevatorService elevatorService = new ElevatorService(3, 10);
        ElevatorController elevatorController = new ElevatorController(elevatorService);

        elevatorController.pressButton(3, Direction.UP);
        elevatorController.pressButton(7, Direction.DOWN);
        elevatorController.pressButton(2, Direction.UP);
        elevatorController.pressButton(9, Direction.DOWN);
        elevatorController.pressButton(5, Direction.UP);

        for (int i = 0; i < 15; i++) {
            IO.println("Step : " + (i + 1));
            elevatorController.stepElevators();
            IO.println();
        }
    }
}
