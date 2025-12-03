package Travel_Tickets.model;

/**
 * Type of ticket chosen by the customer.
 */
public enum TicketType {
    SINGLE("Single", 1.0),
    RETURN("Return", 2.0);

    private final String displayName;
    private final double multiplier;

    TicketType(String displayName, double multiplier) {
        this.displayName = displayName;
        this.multiplier = multiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
