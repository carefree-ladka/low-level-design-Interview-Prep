package parkinglot.model;

import module java.base;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;

    public Ticket(String ticketId, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "===== PARKING TICKET =====\n" +
                       "Ticket ID   : " + ticketId + "\n" +
                       "Vehicle     : " + vehicle + "\n" +
                       "Entry Time  : " + entryTime.format(formatter) + "\n" +
                       "==========================";
    }
}
