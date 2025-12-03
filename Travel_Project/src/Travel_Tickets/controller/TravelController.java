package Travel_Tickets.controller;

import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;

import Travel_Tickets.model.ClassType;
import Travel_Tickets.model.Destination;
import Travel_Tickets.model.FareBreakdown;
import Travel_Tickets.model.Ticket;
import Travel_Tickets.model.TicketType;
import Travel_Tickets.service.FareCalculator;
import Travel_Tickets.service.TicketNumberGenerator;
import Travel_Tickets.view.TravelView;

/**
 * Wires the view to the fare calculator and keeps the UI updated.
 */
public class TravelController {
    private final TravelView view;
    private final FareCalculator calculator;

    public TravelController(TravelView view, FareCalculator calculator) {
        this.view = view;
        this.calculator = calculator;
        attachListeners();
        refreshTotals();
    }

    private void attachListeners() {
        ActionListener recomputeListener = e -> refreshTotals();
        ChangeListener spinnerListener = e -> refreshTotals();

        view.getEconomyClass().addActionListener(recomputeListener);
        view.getBusinessClass().addActionListener(recomputeListener);
        view.getFirstClass().addActionListener(recomputeListener);
        view.getSingleTicket().addActionListener(recomputeListener);
        view.getReturnTicket().addActionListener(recomputeListener);
        view.getDestinationBox().addActionListener(recomputeListener);
        view.getAdultSpinner().addChangeListener(spinnerListener);
        view.getChildSpinner().addChangeListener(spinnerListener);

        view.getCalculateButton().addActionListener(recomputeListener);
        view.getResetButton().addActionListener(e -> reset());
        view.getExitButton().addActionListener(e -> view.dispose());
    }

    private void refreshTotals() {
        try {
            Ticket ticket = buildTicketFromInputs();
            ticket.refreshTimestamp();
            ticket.setTicketNumber(TicketNumberGenerator.generate(8));
            FareBreakdown breakdown = calculator.calculateFare(ticket);
            view.updateSummary(ticket, breakdown);
        } catch (IllegalArgumentException ex) {
            view.showError(ex.getMessage());
            view.clearSummary();
        }
    }

    private Ticket buildTicketFromInputs() {
        Ticket ticket = new Ticket();
        ticket.setClassType(resolveClassType());
        ticket.setTicketType(resolveTicketType());
        ticket.setDestination((Destination) view.getDestinationBox().getSelectedItem());
        ticket.setAdultCount((int) view.getAdultSpinner().getValue());
        ticket.setChildCount((int) view.getChildSpinner().getValue());
        validateTicket(ticket);
        return ticket;
    }

    private void validateTicket(Ticket ticket) {
        if (ticket.getClassType() == null) {
            throw new IllegalArgumentException("Please select a class option first.");
        }
        if (ticket.getTicketType() == null) {
            throw new IllegalArgumentException("Please choose single or return ticket.");
        }
        if (ticket.getDestination() == null) {
            throw new IllegalArgumentException("Please pick a destination to continue.");
        }
        if (ticket.getAdultCount() < 0 || ticket.getChildCount() < 0) {
            throw new IllegalArgumentException("Passenger counts cannot be negative.");
        }
        if (ticket.getAdultCount() + ticket.getChildCount() == 0) {
            throw new IllegalArgumentException("At least one passenger must travel.");
        }
    }

    private ClassType resolveClassType() {
        return mapRadioToValue(view.getFirstClass(), ClassType.FIRST, view.getBusinessClass(), ClassType.BUSINESS,
                view.getEconomyClass(), ClassType.ECONOMY);
    }

    private TicketType resolveTicketType() {
        return mapRadioToValue(view.getSingleTicket(), TicketType.SINGLE, view.getReturnTicket(), TicketType.RETURN);
    }

    private <T> T mapRadioToValue(JRadioButton firstButton, T firstValue, JRadioButton secondButton, T secondValue) {
        if (firstButton.isSelected()) {
            return firstValue;
        }
        if (secondButton.isSelected()) {
            return secondValue;
        }
        return null;
    }

    private <T> T mapRadioToValue(JRadioButton firstButton, T firstValue, JRadioButton secondButton, T secondValue,
            JRadioButton thirdButton, T thirdValue) {
        if (firstButton.isSelected()) {
            return firstValue;
        }
        if (secondButton.isSelected()) {
            return secondValue;
        }
        if (thirdButton.isSelected()) {
            return thirdValue;
        }
        return null;
    }

    private void reset() {
        view.applyDefaults();
        view.clearSummary();
        refreshTotals();
    }
}
