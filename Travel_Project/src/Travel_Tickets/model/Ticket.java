package Travel_Tickets.model;

import java.time.LocalDateTime;

/**
 * Core ticket data captured from the UI.
 */
public class Ticket {
    private ClassType classType;
    private TicketType ticketType;
    private Destination destination;
    private int adultCount;
    private int childCount;
    private LocalDateTime createdAt;
    private String ticketNumber;

    public Ticket() {
        this.createdAt = LocalDateTime.now();
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void refreshTimestamp() {
        this.createdAt = LocalDateTime.now();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
