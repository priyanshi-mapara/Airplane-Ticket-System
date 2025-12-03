package Travel_Tickets.model;

/**
 * Holds computed fare values for display.
 */
public class FareBreakdown {
    private final double classFare;
    private final double subtotal;
    private final double tax;
    private final double total;

    public FareBreakdown(double classFare, double subtotal, double tax, double total) {
        this.classFare = classFare;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
    }

    public double getClassFare() {
        return classFare;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }
}
