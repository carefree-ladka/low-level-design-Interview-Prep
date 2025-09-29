package elevatorsystem.model;

public class Person {
    private String name;
    private int destionationFloor;

    public Person(String name, int destionationFloor) {
        this.name = name;
        this.destionationFloor = destionationFloor;
    }

    public int getDestionationFloor() {
        return destionationFloor;
    }
}
