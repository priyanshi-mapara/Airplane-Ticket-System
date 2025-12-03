package Travel_Tickets.model;

/**
 * Supported cabin classes.
 */
public enum ClassType {
    ECONOMY("Economy"),
    BUSINESS("Business"),
    FIRST("First");

    private final String displayName;

    ClassType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
