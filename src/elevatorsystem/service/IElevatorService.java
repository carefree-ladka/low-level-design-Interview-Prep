package elevatorsystem.service;

import elevatorsystem.model.FloorRequest;

public interface IElevatorService {
    void requestFloor(FloorRequest floorRequest);

    void step(); // Move all elevators one step
}
