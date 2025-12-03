package Travel_Tickets.model;

/**
 * Supported destinations and their default routes.
 */
public enum Destination {
    LONDON("London", "Via: Dubai"),
    PARIS("Paris", "Direct"),
    NEW_YORK("New York", "Direct"),
    SYDNEY("Sydney", "Via: Singapore"),
    LOS_ANGELES("Los Angeles", "Direct");

    private final String displayName;
    private final String route;

    Destination(String displayName, String route) {
        this.displayName = displayName;
        this.route = route;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
