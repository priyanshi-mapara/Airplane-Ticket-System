package Travel_Tickets.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import Travel_Tickets.model.Destination;
import Travel_Tickets.model.FareBreakdown;
import Travel_Tickets.model.Ticket;

/**
 * Builds and exposes the UI controls.
 */
public class TravelView extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final Color WINDOW_BACKGROUND = new Color(238, 244, 249);
    private static final Color CARD_BACKGROUND = Color.WHITE;
    private static final Color BORDER_COLOR = new Color(210, 220, 232);
    private static final Color PRIMARY = new Color(16, 76, 136);
    private static final Color ACCENT = new Color(255, 152, 0);
    private static final Color FIELD_BACKGROUND = new Color(245, 248, 252);
    private static final Color PLACEHOLDER_COLOR = new Color(140, 150, 160);
    private static final Color ERROR_COLOR = new Color(201, 79, 79);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 32);
    private static final Font SECTION_FONT = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font LABEL_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font SMALL_FONT = new Font("Segoe UI", Font.PLAIN, 12);
    private static final int CARD_PADDING = 20;

    private final JRadioButton economyClass = new JRadioButton("Economy");
    private final JRadioButton businessClass = new JRadioButton("Business");
    private final JRadioButton firstClass = new JRadioButton("First");

    private final JRadioButton singleTicket = new JRadioButton("Single");
    private final JRadioButton returnTicket = new JRadioButton("Return");

    private JPanel classChoicePanel;
    private JPanel tripChoicePanel;
    private JPanel passengerRowPanel;
    private JPanel destinationRowPanel;

    private final JComboBox<Destination> destinationBox = new JComboBox<>(Destination.values());
    private final JSpinner adultSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
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

    private final JLabel messageLabel = new JLabel(" ");

    public TravelView() {
        setTitle("AeroFly - Ticketing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1300, 740);
        setLocationRelativeTo(null);
        getContentPane().setBackground(WINDOW_BACKGROUND);
        buildLayout();
        applyDefaults();
    }

    private void buildLayout() {
        JPanel contentPane = new JPanel(new BorderLayout(15, 15));
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setBackground(getContentPane().getBackground());
        setContentPane(contentPane);

        contentPane.add(buildHeader(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(contentPane.getBackground());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 15, 0, 0);
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
        header.setBackground(PRIMARY);
        header.setBorder(BorderFactory.createEmptyBorder(16, 24, 16, 24));
        JLabel title = new JLabel("BOOK YOUR TICKET");
        title.setForeground(Color.WHITE);
        title.setFont(TITLE_FONT);
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
        bookingPanel.setBackground(CARD_BACKGROUND);
        bookingPanel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(CARD_PADDING, CARD_PADDING, CARD_PADDING, CARD_PADDING)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel bookingLabel = new JLabel("Ticket Type");
        bookingLabel.setFont(TITLE_FONT);
        bookingLabel.setForeground(PRIMARY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        bookingPanel.add(bookingLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(2, 8, 14, 8);
        messageLabel.setFont(SMALL_FONT);
        messageLabel.setForeground(ERROR_COLOR);
        bookingPanel.add(messageLabel, gbc);
        gbc.insets = new Insets(6, 8, 6, 8);

        gbc.gridy++;
        bookingPanel.add(buildPassengerGrid(), gbc);

        gbc.gridy++;
        bookingPanel.add(new JSeparator(), gbc);

        gbc.gridy++;
        bookingPanel.add(buildFarePanel(), gbc);

        gbc.gridy++;
        bookingPanel.add(buildButtonRow(), gbc);

        makeReadOnlyFields();
        buildGroups();
        styleInputs();
        return bookingPanel;
    }

    private JPanel buildSummaryPanel() {
        JPanel summaryPanel = new JPanel(new GridBagLayout());
        summaryPanel.setBackground(CARD_BACKGROUND);
        summaryPanel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(CARD_PADDING, CARD_PADDING, CARD_PADDING, CARD_PADDING)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1;

        JLabel header = new JLabel("Passenger Ticket");
        header.setFont(TITLE_FONT);
        header.setForeground(PRIMARY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        summaryPanel.add(header, gbc);

        JLabel chip = new JLabel("AeroFly");
        chip.setOpaque(true);
        chip.setHorizontalAlignment(SwingConstants.CENTER);
        chip.setBackground(ACCENT);
        chip.setForeground(Color.WHITE);
        chip.setFont(new Font("Segoe UI", Font.BOLD, 14));
        chip.setBorder(new EmptyBorder(6, 12, 6, 12));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        summaryPanel.add(chip, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        summaryPanel.add(buildSummaryGrid(), gbc);

        return summaryPanel;
    }

    private JPanel buildPassengerGrid() {
        JPanel grid = new JPanel(new GridBagLayout());
        grid.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel formTitle = new JLabel("Ticket Details");
        formTitle.setFont(SECTION_FONT);
        formTitle.setForeground(PRIMARY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        grid.add(formTitle, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        gbc.gridx = 0;
        classChoicePanel = buildChoicePanel("Ticket Class", firstClass, businessClass, economyClass);
        grid.add(classChoicePanel, gbc);
        gbc.gridx = 1;
        tripChoicePanel = buildChoicePanel("Trip Type", singleTicket, returnTicket);
        grid.add(tripChoicePanel, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        passengerRowPanel = buildPassengerRow();
        grid.add(passengerRowPanel, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        destinationRowPanel = buildDestinationRow();
        grid.add(destinationRowPanel, gbc);

        return grid;
    }

    private JPanel buildDestinationRow() {
        JPanel row = new JPanel(new GridBagLayout());
        row.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel label = new JLabel("Destination");
        label.setFont(LABEL_FONT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        row.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        destinationBox.setFont(LABEL_FONT);
        destinationBox.setRenderer(new PlaceholderRenderer("Select Destination…"));
        destinationBox.setPreferredSize(destinationBox.getPreferredSize());
        row.add(destinationBox, gbc);
        row.setBorder(defaultChoiceBorder());
        return row;
    }

    private JPanel buildPassengerRow() {
        JPanel row = new JPanel(new GridBagLayout());
        row.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel adultsLabel = new JLabel("Adults");
        adultsLabel.setFont(LABEL_FONT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        row.add(adultsLabel, gbc);

        gbc.gridx = 1;
        adultSpinner.setPreferredSize(adultSpinner.getPreferredSize());
        row.add(adultSpinner, gbc);

        JLabel childrenLabel = new JLabel("Children");
        childrenLabel.setFont(LABEL_FONT);
        gbc.gridx = 2;
        row.add(childrenLabel, gbc);

        gbc.gridx = 3;
        row.add(childSpinner, gbc);
        row.setBorder(defaultChoiceBorder());
        return row;
    }

    private JPanel buildChoicePanel(String title, JRadioButton... options) {
        JPanel panel = new JPanel(new GridLayout(0, options.length, 8, 0));
        panel.setOpaque(false);
        panel.setBorder(defaultChoiceBorder());

        JPanel container = new JPanel(new BorderLayout(0, 8));
        container.setOpaque(false);
        JLabel heading = new JLabel(title);
        heading.setFont(SECTION_FONT);
        heading.setForeground(PRIMARY);
        container.add(heading, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);

        for (JRadioButton option : options) {
            panel.add(styleRadio(option));
        }

        return container;
    }

    private JPanel buildFarePanel() {
        JPanel farePanel = new JPanel(new GridBagLayout());
        farePanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 4, 6, 4);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel title = new JLabel("Fare Breakdown");
        title.setFont(SECTION_FONT);
        title.setForeground(PRIMARY);
        gbc.gridwidth = 2;
        farePanel.add(title, gbc);
        gbc.gridwidth = 1;

        gbc.gridy++;
        addFareRow(farePanel, gbc, "Tax", taxField);
        gbc.gridy++;
        addFareRow(farePanel, gbc, "Sub Total", subtotalField);
        gbc.gridy++;
        addFareRow(farePanel, gbc, "Total", totalField);
        gbc.gridy++;
        addFareRow(farePanel, gbc, "Class Fare", classFareField);

        return farePanel;
    }

    private JPanel buildButtonRow() {
        JPanel row = new JPanel(new GridBagLayout());
        row.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 4, 0, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        styleButton(calculateButton, true, false);
        styleButton(exitButton, true, false);
        styleButton(resetButton, false, true);

        gbc.gridx = 0;
        gbc.gridy = 0;
        row.add(calculateButton, gbc);
        gbc.gridx++;
        row.add(resetButton, gbc);
        gbc.gridx++;
        row.add(exitButton, gbc);
        return row;
    }

    private JPanel buildSummaryGrid() {
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;

        int row = 0;
        addSummaryRow(wrapper, gbc, "Class", summaryClass, row, 0);
        addSummaryRow(wrapper, gbc, "Ticket Type", summaryTicket, row++, 1);

        addSummaryRow(wrapper, gbc, "Adult", summaryAdult, row, 0);
        addSummaryRow(wrapper, gbc, "Child", summaryChild, row++, 1);

        addSummaryRow(wrapper, gbc, "From", summaryFrom, row, 0);
        addSummaryRow(wrapper, gbc, "To", summaryTo, row++, 1);

        addSummaryRow(wrapper, gbc, "Date", summaryDate, row, 0);
        addSummaryRow(wrapper, gbc, "Time", summaryTime, row++, 1);

        addSummaryRow(wrapper, gbc, "Ticket No", summaryTicketNo, row, 0);
        addSummaryRow(wrapper, gbc, "Price", summaryPrice, row++, 1);

        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        wrapper.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;
        row++;

        addSummaryRow(wrapper, gbc, "Route", summaryRoute, row, 0, 2);

        return wrapper;
    }

    private void addFareRow(JPanel panel, GridBagConstraints gbc, String label, JTextField field) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(LABEL_FONT);
        gbc.gridx = 0;
        panel.add(jLabel, gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void addSummaryRow(JPanel panel, GridBagConstraints gbc, String label, JTextField target, int row, int col) {
        addSummaryRow(panel, gbc, label, target, row, col, 1);
    }

    private void addSummaryRow(JPanel panel, GridBagConstraints gbc, String label, JTextField target, int row, int col,
            int span) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(LABEL_FONT);
        gbc.gridx = col * 2;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        panel.add(jLabel, gbc);

        gbc.gridx = col * 2 + 1;
        gbc.gridwidth = span;
        panel.add(target, gbc);
        gbc.gridwidth = 1;
    }

    private JRadioButton styleRadio(JRadioButton button) {
        button.setBackground(CARD_BACKGROUND);
        button.setFont(LABEL_FONT);
        return button;
    }

    private void styleInputs() {
        JSpinner[] spinners = { adultSpinner, childSpinner };
        for (JSpinner spinner : spinners) {
            spinner.setFont(LABEL_FONT);
            spinner.setBorder(new LineBorder(BORDER_COLOR, 1, true));
            spinner.setPreferredSize(spinner.getPreferredSize());
        }
        JComboBox<?>[] boxes = { destinationBox };
        for (JComboBox<?> box : boxes) {
            box.setBorder(new LineBorder(BORDER_COLOR, 1, true));
        }
    }

    private void styleButton(JButton button, boolean solid, boolean muted) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(solid ? Color.WHITE : PRIMARY);
        button.setBackground(solid ? Color.BLACK : CARD_BACKGROUND);
        button.setBorder(BorderFactory.createCompoundBorder(new LineBorder(solid ? Color.BLACK : BORDER_COLOR, 1, true),
                new EmptyBorder(8, 12, 8, 12)));
        if (muted) {
            button.setForeground(PRIMARY);
        }
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setPreferredSize(button.getPreferredSize());
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
            field.setBackground(FIELD_BACKGROUND);
            field.setBorder(new LineBorder(BORDER_COLOR, 1, true));
            field.setFont(LABEL_FONT);
            field.setPreferredSize(field.getPreferredSize());
        }
    }

    public void applyDefaults() {
        classGroup.clearSelection();
        ticketGroup.clearSelection();
        destinationBox.setSelectedItem(null);
        adultSpinner.setValue(0);
        childSpinner.setValue(0);
        clearValidation();
        clearSummary();
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
        highlightValidation(message);
    }

    public void updateSummary(Ticket ticket, FareBreakdown breakdown) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        clearValidation();
        setSummaryEnabled(true);

        setFieldValue(summaryClass, ticket.getClassType().getDisplayName());
        setFieldValue(summaryTicket, ticket.getTicketType().getDisplayName());
        setFieldValue(summaryAdult, String.valueOf(ticket.getAdultCount()));
        setFieldValue(summaryChild, String.valueOf(ticket.getChildCount()));
        setFieldValue(summaryFrom, "India");
        setFieldValue(summaryTo, ticket.getDestination().getDisplayName());
        setFieldValue(summaryDate, dateFormatter.format(ticket.getCreatedAt()));
        setFieldValue(summaryTime, timeFormatter.format(ticket.getCreatedAt()));
        setFieldValue(summaryTicketNo, ticket.getTicketNumber());
        setFieldValue(summaryPrice, formatMoney(breakdown.getTotal()));
        setFieldValue(summaryRoute, ticket.getDestination().getRoute());

        setFieldValue(classFareField, formatMoney(breakdown.getClassFare()));
        setFieldValue(subtotalField, formatMoney(breakdown.getSubtotal()));
        setFieldValue(taxField, formatMoney(breakdown.getTax()));
        setFieldValue(totalField, formatMoney(breakdown.getTotal()));
    }

    public void clearSummary() {
        JTextField[] fields = { taxField, subtotalField, totalField, classFareField, summaryClass, summaryTicket,
                summaryAdult, summaryChild, summaryFrom, summaryTo, summaryDate, summaryTime, summaryTicketNo,
                summaryPrice, summaryRoute };
        for (JTextField field : fields) {
            setPlaceholder(field);
        }
        setSummaryEnabled(false);
    }

    private String formatMoney(double value) {
        return String.format("Rs %.2f", value);
    }

    private void setFieldValue(JTextField field, String value) {
        field.setForeground(Color.DARK_GRAY);
        field.setText(value);
    }

    private void setPlaceholder(JTextField field) {
        field.setForeground(PLACEHOLDER_COLOR);
        field.setText("—");
    }

    private void setSummaryEnabled(boolean enabled) {
        JTextField[] fields = { summaryClass, summaryTicket, summaryAdult, summaryChild, summaryFrom, summaryTo,
                summaryDate, summaryTime, summaryTicketNo, summaryPrice, summaryRoute };
        for (JTextField field : fields) {
            field.setEnabled(enabled);
        }
    }

    private void highlightValidation(String message) {
        clearValidation();
        if (message == null || message.isBlank()) {
            return;
        }
        messageLabel.setText(message);
        if (message.contains("class option")) {
            setErrorBorder(classChoicePanel);
        }
        if (message.contains("single or return")) {
            setErrorBorder(tripChoicePanel);
        }
        if (message.contains("destination")) {
            setErrorBorder(destinationRowPanel);
        }
        if (message.contains("least one passenger")) {
            setErrorBorder(passengerRowPanel);
        }
    }

    private void clearValidation() {
        messageLabel.setText(" ");
        resetBorder(classChoicePanel);
        resetBorder(tripChoicePanel);
        resetBorder(destinationRowPanel);
        resetBorder(passengerRowPanel);
    }

    private void setErrorBorder(JPanel panel) {
        if (panel != null) {
            panel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(ERROR_COLOR, 2, true),
                    new EmptyBorder(10, 10, 10, 10)));
        }
    }

    private void resetBorder(JPanel panel) {
        if (panel == null) {
            return;
        }
        panel.setBorder(defaultChoiceBorder());
    }

    private EmptyBorder defaultChoicePadding() {
        return new EmptyBorder(10, 10, 10, 10);
    }

    private javax.swing.border.Border defaultChoiceBorder() {
        return BorderFactory.createCompoundBorder(new LineBorder(BORDER_COLOR, 1, true), defaultChoicePadding());
    }

    private static class PlaceholderRenderer extends BasicComboBoxRenderer {
        private static final long serialVersionUID = 1L;
        private final String placeholder;

        PlaceholderRenderer(String placeholder) {
            this.placeholder = placeholder;
            setHorizontalAlignment(SwingConstants.LEFT);
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JComboBox list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value == null && index == -1) {
                setForeground(PLACEHOLDER_COLOR);
                setText(placeholder);
            } else {
                setForeground(Color.DARK_GRAY);
                setText(value == null ? "" : value.toString());
            }
            return this;
        }
    }
}
