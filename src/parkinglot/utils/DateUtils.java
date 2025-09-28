package parkinglot.utils;

import module java.base;
import parkinglot.model.Ticket;

public final class DateUtils {

    private DateUtils() {
    }

    public static long getHoursBetweenTicketAndNow(Ticket ticket) {
        return Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
    }
}
