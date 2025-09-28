package parkinglot.strategy;

import module java.base;
import parkinglot.model.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        return (hours == 0 ? 1 : hours) * 20.0; // ₹20 per hour
    }
}
