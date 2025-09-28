package parkinglot.service;

import parkinglot.model.Ticket;
import parkinglot.strategy.PricingStrategy;

public class PaymentService {
    private PricingStrategy pricingStrategy;

    public PaymentService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double processPayment(Ticket ticket) {
        double amount = pricingStrategy.calculatePrice(ticket);
        IO.println("Payment processed: " + amount);
        return amount;
    }
}
