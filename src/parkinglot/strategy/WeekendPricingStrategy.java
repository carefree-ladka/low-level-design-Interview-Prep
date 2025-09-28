package parkinglot.strategy;

import module java.base;
import parkinglot.model.Ticket;
import parkinglot.utils.DateUtils;

public class WeekendPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Ticket ticket) {
        DayOfWeek day = LocalDateTime.now().getDayOfWeek();
        long hours = DateUtils.getHoursBetweenTicketAndNow(ticket);
        double rate = (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) ? 30.0 : 20.0;
        return (hours == 0 ? 1 : hours) * rate;
    }
}
