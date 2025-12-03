package Travel_Tickets.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Travel_Tickets.model.Destination;
import Travel_Tickets.model.FareBreakdown;
import Travel_Tickets.model.Ticket;

/**
 * Builds and exposes the UI controls.
 */
public class TravelView extends JFrame {
    private static final long serialVersionUID = 1L;

    private final Color primary = new Color(0, 82, 155);
    private final Color accent = new Color(244, 137, 37);
    private final Color surface = new Color(248, 252, 255);
    private final Color outline = new Color(202, 224, 244);
    private final Font headingFont = new Font("Segoe UI", Font.BOLD, 32);
    private final Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

    private final JRadioButton economyClass = new JRadioButton("Economy");
    private final JRadioButton businessClass = new JRadioButton("Business");
    private final JRadioButton firstClass = new JRadioButton("First");

    private final JRadioButton singleTicket = new JRadioButton("Single");
    private final JRadioButton returnTicket = new JRadioButton("Return");

    private final JComboBox<Destination> destinationBox = new JComboBox<>(Destination.values());
    private final JSpinner adultSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
    private final JSpinner childSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

    private final JTextField taxField = new JTextField();
    private final JTextField subtotalField = new JTextField();
    private final JTextField totalField = new JTextField();
    private final JTextField classFareField = new JTextField();

    private final JTextField summaryClass = new JTextField();
    private final JTextField summaryTicket = new JTextField();
    private final JTextField summaryAdult = new JTextField();
    private final JTextField summaryChild = new JTextField();
    private final JTextField summaryFrom = new JTextField();
    private final JTextField summaryTo = new JTextField();
    private final JTextField summaryDate = new JTextField();
    private final JTextField summaryTime = new JTextField();
    private final JTextField summaryTicketNo = new JTextField();
    private final JTextField summaryPrice = new JTextField();
    private final JTextField summaryRoute = new JTextField();

    private final JButton calculateButton = new JButton("Calculate");
    private final JButton resetButton = new JButton("Reset");
    private final JButton exitButton = new JButton("Exit");

    private final ButtonGroup classGroup = new ButtonGroup();
    private final ButtonGroup ticketGroup = new ButtonGroup();

    public TravelView() {
        setTitle("AeroFly - Ticketing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1250, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(232, 241, 250));
        buildLayout();
        applyDefaults();
    }

    private void buildLayout() {
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(getContentPane().getBackground());
        setContentPane(contentPane);

        contentPane.add(buildHeader(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(contentPane.getBackground());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(buildBookingPanel(), gbc);

        gbc.gridx = 1;
        centerPanel.add(buildSummaryPanel(), gbc);
        contentPane.add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel buildHeader() {
        JPanel header = new JPanel();
        header.setBackground(primary);
        JLabel title = new JLabel("BOOK YOUR TICKET");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 40));
        header.add(title);
        JLabel subtitle = new JLabel("Seamless bookings with AeroFly");
        subtitle.setForeground(Color.WHITE);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitle.setBorder(new EmptyBorder(0, 15, 0, 0));
        header.add(subtitle);
        return header;
    }

    private JPanel buildBookingPanel() {
        JPanel bookingPanel = new JPanel(new GridBagLayout());
        bookingPanel.setBackground(surface);
        bookingPanel.setBorder(new LineBorder(outline, 2, true));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel bookingLabel = new JLabel("Ticket Type");
        bookingLabel.setFont(headingFont);
        bookingLabel.setForeground(primary);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        bookingPanel.add(bookingLabel, gbc);

        // class options
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        bookingPanel.add(styleRadio(firstClass), gbc);
        gbc.gridx = 1;
        bookingPanel.add(styleRadio(businessClass), gbc);
        gbc.gridx = 2;
        bookingPanel.add(styleRadio(economyClass), gbc);

        // ticket type
        gbc.gridy++;
        gbc.gridx = 0;
        bookingPanel.add(styleRadio(singleTicket), gbc);
        gbc.gridx = 1;
        bookingPanel.add(styleRadio(returnTicket), gbc);

        // passengers
        gbc.gridy++;
        gbc.gridx = 0;
        bookingPanel.add(new JLabel("Adults"), gbc);
        gbc.gridx = 1;
        bookingPanel.add(adultSpinner, gbc);
        gbc.gridx = 2;
        bookingPanel.add(new JLabel("Children"), gbc);
        gbc.gridx = 3;
        bookingPanel.add(childSpinner, gbc);

        // destinations
        gbc.gridy++;
        gbc.gridx = 0;
        bookingPanel.add(new JLabel("Destination"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        destinationBox.setFont(labelFont);
        bookingPanel.add(destinationBox, gbc);

        // separator
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        bookingPanel.add(new JSeparator(), gbc);

        // fare breakdown labels
        gbc.gridy++;
        gbc.gridwidth = 2;
        JLabel fareLabel = new JLabel("Fare Breakdown");
        fareLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        fareLabel.setForeground(primary);
        bookingPanel.add(fareLabel, gbc);

        // tax row
        gbc.gridy++;
        gbc.gridwidth = 1;
        addLabeledField(bookingPanel, gbc, "Tax", taxField);

        // subtotal row
        gbc.gridy++;
        addLabeledField(bookingPanel, gbc, "Sub Total", subtotalField);

        // total row
        gbc.gridy++;
        addLabeledField(bookingPanel, gbc, "Total", totalField);

        // class fare
        gbc.gridy++;
        addLabeledField(bookingPanel, gbc, "Class Fare", classFareField);

        // buttons
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        calculateButton.setBackground(primary);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        bookingPanel.add(calculateButton, gbc);

        gbc.gridx = 1;
        resetButton.setBackground(outline);
        resetButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        bookingPanel.add(resetButton, gbc);

        gbc.gridx = 2;
        exitButton.setBackground(new Color(230, 99, 99));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        bookingPanel.add(exitButton, gbc);

        makeReadOnlyFields();
        buildGroups();
        return bookingPanel;
    }

    private JPanel buildSummaryPanel() {
        JPanel summaryPanel = new JPanel(new GridBagLayout());
        summaryPanel.setBackground(Color.WHITE);
        summaryPanel.setBorder(new LineBorder(outline, 2, true));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;

        JLabel header = new JLabel("Passenger Ticket");
        header.setFont(new Font("Segoe UI", Font.BOLD, 24));
        header.setForeground(primary);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        summaryPanel.add(header, gbc);

        JLabel chip = new JLabel("AeroFly");
        chip.setOpaque(true);
        chip.setHorizontalAlignment(SwingConstants.CENTER);
        chip.setBackground(accent);
        chip.setForeground(Color.WHITE);
        chip.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        summaryPanel.add(chip, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        summaryPanel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        addSummaryRow(summaryPanel, gbc, "Class", summaryClass, 0);
        addSummaryRow(summaryPanel, gbc, "Ticket", summaryTicket, 1);
        addSummaryRow(summaryPanel, gbc, "Adult", summaryAdult, 2);
        addSummaryRow(summaryPanel, gbc, "Child", summaryChild, 3);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        summaryPanel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        addSummaryRow(summaryPanel, gbc, "From", summaryFrom, 0);
        addSummaryRow(summaryPanel, gbc, "To", summaryTo, 1);
        addSummaryRow(summaryPanel, gbc, "Date", summaryDate, 2);
        addSummaryRow(summaryPanel, gbc, "Time", summaryTime, 3);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        summaryPanel.add(new JSeparator(), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        addSummaryRow(summaryPanel, gbc, "Ticket No", summaryTicketNo, 0);
        addSummaryRow(summaryPanel, gbc, "Price", summaryPrice, 1);
        addSummaryRow(summaryPanel, gbc, "Route", summaryRoute, 2);

        return summaryPanel;
    }

    private void addLabeledField(JPanel panel, GridBagConstraints gbc, String label, JTextField field) {
        field.setEditable(false);
        field.setBackground(Color.WHITE);
        JLabel jLabel = new JLabel(label + ":");
        jLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(jLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        panel.add(field, gbc);
    }

    private void addSummaryRow(JPanel panel, GridBagConstraints gbc, String label, JTextField target, int column) {
        JLabel jLabel = new JLabel(label + ":");
        jLabel.setFont(labelFont);
        gbc.gridx = column;
        panel.add(jLabel, gbc);
        gbc.gridy++;
        target.setEditable(false);
        target.setBackground(Color.WHITE);
        panel.add(target, gbc);
        gbc.gridy--;
    }

    private JRadioButton styleRadio(JRadioButton button) {
        button.setBackground(surface);
        button.setFont(labelFont);
        return button;
    }

    private void buildGroups() {
        classGroup.add(firstClass);
        classGroup.add(businessClass);
        classGroup.add(economyClass);
        ticketGroup.add(singleTicket);
        ticketGroup.add(returnTicket);
    }

    private void makeReadOnlyFields() {
        JTextField[] fields = { taxField, subtotalField, totalField, classFareField, summaryClass, summaryTicket,
                summaryAdult, summaryChild, summaryFrom, summaryTo, summaryDate, summaryTime, summaryTicketNo,
                summaryPrice, summaryRoute };
        for (JTextField field : fields) {
            field.setEditable(false);
            field.setBackground(Color.WHITE);
        }
    }

    public void applyDefaults() {
        economyClass.setSelected(true);
        returnTicket.setSelected(true);
        destinationBox.setSelectedItem(Destination.LONDON);
        adultSpinner.setValue(1);
        childSpinner.setValue(0);
    }

    public JRadioButton getEconomyClass() {
        return economyClass;
    }

    public JRadioButton getBusinessClass() {
        return businessClass;
    }

    public JRadioButton getFirstClass() {
        return firstClass;
    }

    public JRadioButton getSingleTicket() {
        return singleTicket;
    }

    public JRadioButton getReturnTicket() {
        return returnTicket;
    }

    public JComboBox<Destination> getDestinationBox() {
        return destinationBox;
    }

    public JSpinner getAdultSpinner() {
        return adultSpinner;
    }

    public JSpinner getChildSpinner() {
        return childSpinner;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input error", JOptionPane.WARNING_MESSAGE);
    }

    public void updateSummary(Ticket ticket, FareBreakdown breakdown) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        summaryClass.setText(ticket.getClassType().getDisplayName());
        summaryTicket.setText(ticket.getTicketType().getDisplayName());
        summaryAdult.setText(String.valueOf(ticket.getAdultCount()));
        summaryChild.setText(String.valueOf(ticket.getChildCount()));
        summaryFrom.setText("India");
        summaryTo.setText(ticket.getDestination().getDisplayName());
        summaryDate.setText(dateFormatter.format(ticket.getCreatedAt()));
        summaryTime.setText(timeFormatter.format(ticket.getCreatedAt()));
        summaryTicketNo.setText(ticket.getTicketNumber());
        summaryPrice.setText(formatMoney(breakdown.getTotal()));
        summaryRoute.setText(ticket.getDestination().getRoute());

        classFareField.setText(formatMoney(breakdown.getClassFare()));
        subtotalField.setText(formatMoney(breakdown.getSubtotal()));
        taxField.setText(formatMoney(breakdown.getTax()));
        totalField.setText(formatMoney(breakdown.getTotal()));
    }

    public void clearSummary() {
        JTextField[] fields = { taxField, subtotalField, totalField, classFareField, summaryClass, summaryTicket,
                summaryAdult, summaryChild, summaryFrom, summaryTo, summaryDate, summaryTime, summaryTicketNo,
                summaryPrice, summaryRoute };
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    private String formatMoney(double value) {
        return String.format("Rs %.2f", value);
    }
}
