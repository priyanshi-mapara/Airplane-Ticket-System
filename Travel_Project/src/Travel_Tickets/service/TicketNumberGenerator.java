package Travel_Tickets.service;

import java.security.SecureRandom;

/**
 * Generates unique-looking alphanumeric ticket numbers.
 */
public final class TicketNumberGenerator {
    private static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    private TicketNumberGenerator() {
    }

    public static String generate(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(ALPHANUM.charAt(RANDOM.nextInt(ALPHANUM.length())));
        }
        return builder.toString();
    }
}
