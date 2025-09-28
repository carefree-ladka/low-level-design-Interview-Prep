package parkinglot.strategy;

import parkinglot.model.Ticket;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket);
}
