package Travel_Tickets.service;

import Travel_Tickets.model.ClassType;
import Travel_Tickets.model.Destination;
import Travel_Tickets.model.FareBreakdown;
import Travel_Tickets.model.Ticket;
import Travel_Tickets.model.TicketType;

/**
 * Performs fare calculations using the configured rates.
 */
public class FareCalculator {

    public FareBreakdown calculateFare(Ticket ticket) {
        Destination destination = ticket.getDestination();
        ClassType classType = ticket.getClassType();
        TicketType ticketType = ticket.getTicketType();

        if (destination == null || classType == null || ticketType == null) {
            throw new IllegalArgumentException("Ticket information incomplete for fare calculation.");
        }

        double classFare = FareConfig.baseFare(destination, classType) * ticketType.getMultiplier();
        double adultSubtotal = classFare * ticket.getAdultCount();
        double childSubtotal = classFare * FareConfig.CHILD_DISCOUNT * ticket.getChildCount();
        double subtotal = adultSubtotal + childSubtotal;
        double tax = subtotal * FareConfig.TAX_RATE;
        double total = subtotal + tax;

        return new FareBreakdown(classFare, subtotal, tax, total);
    }
}
