package Travel_Tickets.service;

import java.util.EnumMap;
import java.util.Map;

import Travel_Tickets.model.ClassType;
import Travel_Tickets.model.Destination;

/**
 * Central location for fare configuration.
 */
public final class FareConfig {
    public static final double TAX_RATE = 0.08; // 8% tax applied to subtotal
    public static final double CHILD_DISCOUNT = 0.5; // children pay 50% of adult fare

    private static final Map<Destination, Map<ClassType, Double>> BASE_FARES = new EnumMap<>(Destination.class);

    static {
        register(Destination.LONDON, 52000, 68000, 82000);
        register(Destination.PARIS, 50000, 66000, 80000);
        register(Destination.NEW_YORK, 64000, 80000, 96000);
        register(Destination.SYDNEY, 56000, 72000, 86000);
        register(Destination.LOS_ANGELES, 65000, 81000, 95000);
    }

    private FareConfig() {
    }

    private static void register(Destination destination, double economy, double business, double first) {
        Map<ClassType, Double> fares = new EnumMap<>(ClassType.class);
        fares.put(ClassType.ECONOMY, economy);
        fares.put(ClassType.BUSINESS, business);
        fares.put(ClassType.FIRST, first);
        BASE_FARES.put(destination, fares);
    }

    public static double baseFare(Destination destination, ClassType classType) {
        Map<ClassType, Double> fares = BASE_FARES.get(destination);
        if (fares == null || !fares.containsKey(classType)) {
            throw new IllegalArgumentException("No fare configured for destination " + destination + " and class "
                    + classType);
        }
        return fares.get(classType);
    }
}
