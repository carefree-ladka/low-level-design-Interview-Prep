package elevatorsystem.service.impl;

import module java.base;
import elevatorsystem.model.Direction;
import elevatorsystem.model.Elevator;
import elevatorsystem.model.FloorRequest;
import elevatorsystem.service.IElevatorService;

public class ElevatorService implements IElevatorService {
    private List<Elevator> elevators;
    private int totalFloors;

    public ElevatorService(int totalElevators, int totalFloors) {
        this.totalFloors = totalFloors;
        this.elevators = new ArrayList<>();

        for (int i = 1; i <= totalElevators; i++) {
            this.elevators.add(new Elevator(i));
        }
    }

    @Override
    public void requestFloor(FloorRequest floorRequest) {
        Elevator nearest = findNearestElevator(floorRequest);
        nearest.addTargetFloor(floorRequest.getFloor(), floorRequest.getDirection());
        IO.println("Assigned Elevator: " + nearest.getId() + " to floor: " + floorRequest.getFloor() + " ( " + floorRequest.getDirection() + " )");
    }

    @Override
    public void step() {
        elevators.forEach(Elevator::moveOneFloor);
        elevators.forEach(IO::println);
    }

    private Elevator findNearestElevator(FloorRequest floorRequest) {
        return elevators.stream().min(Comparator.comparingInt(e -> {
            if (e.getDirection() == floorRequest.getDirection()) {
                return Math.abs(e.getCurrentFloor()) - floorRequest.getFloor();
            } else if (e.getDirection() == Direction.IDLE) {
                return Math.abs(e.getCurrentFloor()) - floorRequest.getFloor() + 1;
            } else {
                return Math.abs(e.getCurrentFloor()) - floorRequest.getFloor() + 5;
            }
        })).orElseThrow();
    }
}
