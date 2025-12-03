package Travel_Tickets;

import java.awt.EventQueue;

import Travel_Tickets.controller.TravelController;
import Travel_Tickets.service.FareCalculator;
import Travel_Tickets.view.TravelView;

/**
 * Application entry point that wires MVC components.
 */
public class TravelApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TravelView view = new TravelView();
            FareCalculator calculator = new FareCalculator();
            new TravelController(view, calculator);
            view.setVisible(true);
        });
    }
}
