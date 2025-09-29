package elevatorsystem.model;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Elevator {
    private int id;
    private int currentFloor;
    private ElevatorStatus status;
    private Direction direction;

    private PriorityQueue<Integer> upQueue;   // Min-heap for UP requests
    private PriorityQueue<Integer> downQueue; // Max-heap for DOWN requests

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.status = ElevatorStatus.IDLE;
        this.direction = Direction.IDLE;

        upQueue = new PriorityQueue<>();
        downQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public Direction getDirection() {
        return direction;
    }

    // Add request based on direction
    public void addTargetFloor(int floor, Direction reqDirection) {
        if (floor == currentFloor) return; // Already on the floor

        if (floor > currentFloor) {
            upQueue.offer(floor);
        } else {
            downQueue.offer(floor);
        }

        if (status == ElevatorStatus.IDLE) {
            direction = (floor > currentFloor) ? Direction.UP : Direction.DOWN;
            status = ElevatorStatus.MOVING;
        }
    }

    // Move one step
    public void moveOneFloor() {
        if (direction == Direction.UP) {
            if (!upQueue.isEmpty()) {
                int nextFloor = upQueue.peek();
                if (currentFloor < nextFloor) currentFloor++;
                if (currentFloor == nextFloor) upQueue.poll();
            } else if (!downQueue.isEmpty()) {
                direction = Direction.DOWN;
                moveOneFloor();
                return;
            } else {
                direction = Direction.IDLE;
                status = ElevatorStatus.IDLE;
                return;
            }
        } else if (direction == Direction.DOWN) {
            if (!downQueue.isEmpty()) {
                int nextFloor = downQueue.peek();
                if (currentFloor > nextFloor) currentFloor--;
                if (currentFloor == nextFloor) downQueue.poll();
            } else if (!upQueue.isEmpty()) {
                direction = Direction.UP;
                moveOneFloor();
                return;
            } else {
                direction = Direction.IDLE;
                status = ElevatorStatus.IDLE;
                return;
            }
        }

        status = ElevatorStatus.MOVING;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                       "id=" + id +
                       ", currentFloor=" + currentFloor +
                       ", status=" + status +
                       ", direction=" + direction +
                       ", upQueue=" + upQueue +
                       ", downQueue=" + downQueue +
                       '}';
    }
}
